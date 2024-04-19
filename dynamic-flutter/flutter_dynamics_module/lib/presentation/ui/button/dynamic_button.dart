import 'package:flutter/material.dart';
import 'package:flutter_dynamics_module/presentation/ui/text/dynamic_text.dart';

import '../../../data/model/button/button_properties.dart';
import '../../../data/model/text/text_properties.dart';

class DynamicButton extends StatelessWidget {
  final VoidCallback callback;
  final ButtonProperties buttonProperties;

  const DynamicButton(
      {super.key, required this.buttonProperties, required this.callback});

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: () {
        callback();
      },
      child: DynamicText(
        textProperties: TextProperties(
          text: buttonProperties.text,
          textColorHex: buttonProperties.textColorHex,
          textSize: buttonProperties.textSize,
          textAllCaps: buttonProperties.textAllCaps,
          backgroundHex: buttonProperties.backgroundHex,
        ),
      ),
    );
  }
}
