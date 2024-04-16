import 'package:flutter_dynamics_module/flutter_dynamic_module.export.dart';
import 'package:flutter_dynamics_module/presentation/ui/button/dynamic_button_builder.dart';

class DynamicBuilders {
  static final Map<String, DynamicBuilder> _builders = {
    DynamicButtonBuilder.key: DynamicButtonBuilder(),
  };

  static DynamicBuilder getBuilder(String key) {
    return _builders[key]!;//TODO ?: DynamicEmptyComposeRender()
  }
}