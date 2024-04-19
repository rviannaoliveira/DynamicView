import 'package:flutter_dynamics_module/flutter_dynamic_module.export.dart';
import 'package:flutter_dynamics_module/presentation/ui/button/dynamic_button_builder.dart';
import 'package:flutter_dynamics_module/presentation/ui/empty/dynamic_empty.dart';
import 'package:flutter_dynamics_module/presentation/ui/empty/dynamic_empty_builder.dart';
import 'package:flutter_dynamics_module/presentation/ui/text/dynamic_text.dart';
import 'package:flutter_dynamics_module/presentation/ui/text/dynamic_text_builder.dart';

class DynamicBuilders {
  static final Map<String, DynamicBuilder> _builders = {
    DynamicButtonBuilder.key: DynamicButtonBuilder(),
    DynamicTextBuilder.key: DynamicTextBuilder(),
  };

  // fun addBuilderRenders(
  // customDynamicBuilderList: List<DynamicComposeBuilder>
  // ): DynamicComposeBuilders {
  // customBuilders.addAll(customDynamicBuilderList)
  // return this
  // }
  static DynamicBuilder getBuilder(String key,
      {Map<String, DynamicBuilder>? customMap}) {
    if (customMap != null) {
      _builders.addAll(customMap);
    }
    return _builders[key] != null ? _builders[key]! : DynamicEmptyBuilder();
  }
}
