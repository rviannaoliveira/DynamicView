package com.github.rviannaoliveira.dynamic.adapter

import android.util.SparseArray
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.util.valueIterator
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.github.rviannaoliveira.dynamic.adapter.renderes.EmptyViewHolder
import com.github.rviannaoliveira.dynamic.adapter.renderes.ViewRenderer
import com.github.rviannaoliveira.dynamic.domain.model.SimpleProperties

/**
 * The creation I use with base/inspiration two papers :
 * https://medium.com/android-news/simplifying-the-work-with-recyclerview-a64027bca8c3
 * https://medium.com/gustavo-santorio/android-dynamic-views-with-recyclerview-c2974c96a85f
 * Adapter that use viewRenders with type from ViewType
 */
class DynamicAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Dynamic {
    /**
     * Helper for computing the difference between two lists via DiffUtil on a background thread
     */
    private val differ: AsyncListDiffer<SimpleProperties?> =
        AsyncListDiffer(this, SimplePropertiesItemCallback)

    /**
     * List from Renderers to each component with SparseArray is intended to be more memory-efficient than a HashMap
     */
    private var renderers = SparseArray<ViewRenderer<RecyclerView.ViewHolder>>()
    var bindingLiveData: MutableLiveData<Int>? = null

    /**
     * method that take each viewRenderer until viewType from DynamicComponent
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holder = renderers.get(viewType)?.createViewHolder(parent) ?: EmptyViewHolder(
            FrameLayout(parent.context)
        )

        holder.itemView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        return holder
    }

    override fun getItemCount(): Int = differ.currentList.size

    /**
     * Take the item reference that was set in DiffUtils
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bindingLiveData?.value = position
        differ.currentList.getOrNull(position)?.let { vo ->
            findRenderOrNull(vo.key)?.bindView(vo, holder, position)
        }
    }

    /**
     * Tke current SimpleVOs list
     */
    override fun getItemViewType(position: Int): Int {
        return differ.currentList.getOrNull(position)?.let {
            findRenderOrNull(it.key)?.viewType ?: super.getItemViewType(position)
        } ?: super.getItemViewType(position)
    }

    override fun getItemId(position: Int): Long = position.toLong()

    /**
     * Is required register the ViewRender to show on the screen
     */
    override fun registerRenderer(renderer: ViewRenderer<*>) {
        if (renderers.get(renderer.viewType) == null) {
            renderers.put(renderer.viewType, renderer as ViewRenderer<RecyclerView.ViewHolder>)
        }
    }

    /**
     * Is required register the ViewRender to show on the screen and received a list of renders
     */
    override fun registerRenderers(renderers: List<ViewRenderer<*>>) {
        renderers.forEach { registerRenderer(it) }
    }

    override fun getRenderer(viewType: Int): ViewRenderer<RecyclerView.ViewHolder> =
        renderers.get(viewType)

    override fun getRenderers(): List<ViewRenderer<RecyclerView.ViewHolder>> =
        renderers.valueIterator().asSequence().toList()

    override fun setViewObjectDiff(properties: List<SimpleProperties>) {
        differ.submitList(properties)
    }

    override fun updateViewAt(properties: SimpleProperties, index: Int) {
        val list = differ.currentList.toMutableList()
        list[index] = properties
        setViewObjectDiff(list.toList().toList() as List<SimpleProperties>)
    }

    override fun notifyPositionRemovedAt(position: Int) {
        val list = differ.currentList.toMutableList()
        list.removeAt(position)
        setViewObjectDiff(list.toList().toList() as List<SimpleProperties>)
    }

    override fun notifyChanges(properties: List<SimpleProperties>) {
        with(differ) {
            submitList(properties)
        }
        notifyDataSetChanged()
    }

    override fun notifyItemChangeAt(position: Int, payload: Any) {
        notifyItemChanged(position, payload)
    }

    override fun notifyItemChangeAt(position: Int) {
        notifyItemChanged(position)
    }

    private inline fun iterateOnRenders(action: (ViewRenderer<RecyclerView.ViewHolder>) -> Unit) {
        for (i in 0 until renderers.size()) {
            val key = renderers.keyAt(i)
            action(renderers.get(key))
        }
    }

    private fun findRenderOrNull(key: String): ViewRenderer<RecyclerView.ViewHolder>? {
        iterateOnRenders {
            if (it.key == key) return it
        }
        return null
    }

    override fun clear() {
        differ.submitList(emptyList())
    }
}
