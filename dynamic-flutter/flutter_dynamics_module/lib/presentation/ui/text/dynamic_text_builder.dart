import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_dynamics_module/data/model/text/text_properties.dart';
import 'package:flutter_dynamics_module/presentation/builder/dynamic_builder.dart';
import 'package:flutter_dynamics_module/presentation/dynamic_view_listener.dart';
import 'package:flutter_dynamics_module/presentation/ui/button/dynamic_button.dart';
import 'package:flutter_dynamics_module/presentation/ui/text/dynamic_text.dart';

import '../../../data/model/action/dynamic_action_properties.dart';
import '../../../data/model/button/button_properties.dart';

class DynamicTextBuilder extends DynamicBuilder<TextProperties> {
  DynamicTextBuilder() : super(key: key);

  @override
  Widget craft(TextProperties model, DynamicViewListener listener) {
    return DynamicText(
        textProperties: model,
        callback: () {
          if (model.actionProperties != null) {
            listener(model.actionProperties!);
          }
        });
  }

  @override
  TextProperties fromJson(properties) {
    return TextProperties(
        text: properties["text"],
        textColorHex: properties["textColorHex"],
        textSize: properties["textSize"],
        textAllCaps: properties["textAllCaps"],
        backgroundHex: properties["backgroundHex"],
        actionProperties: DynamicActionProperties.fromJson(
            properties[DynamicActionProperties.key]));
  }

  static String key = "DynamicTextView";
}
