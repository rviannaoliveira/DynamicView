import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_dynamics_module/presentation/builder/dynamic_builder.dart';
import 'package:flutter_dynamics_module/presentation/dynamic_view_listener.dart';
import 'package:flutter_dynamics_module/presentation/ui/button/dynamic_button.dart';

import '../../../data/model/button/button_properties.dart';

class DynamicButtonBuilder extends DynamicBuilder<ButtonProperties> {
  DynamicButtonBuilder() : super(key: key);

  @override
  Widget craft(ButtonProperties model, DynamicViewListener listener) {
    return DynamicButton(
      buttonProperties: model,
      callback: () {
        if (model.actionProperties != null) {
          listener(model.actionProperties!);
        }
      },
    );
  }

  @override
  ButtonProperties fromJson(properties) {
    return ButtonProperties(
        text: properties["text"],
        textColorHex: properties["textColorHex"],
        textSize: properties["textSize"],
        textAllCaps: properties["textAllCaps"],
        fillMaxSize: properties["fillMaxSize"],
        backgroundHex: properties["backgroundHex"],
        actionProperties: properties["actionProperties"]);
  }

  static String key = "DynamicButton";
}