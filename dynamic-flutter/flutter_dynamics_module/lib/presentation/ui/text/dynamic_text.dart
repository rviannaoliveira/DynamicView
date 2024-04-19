import 'package:flutter/material.dart';
import 'package:flutter_dynamics_module/data/model/text/text_properties.dart';

import '../helper/dynamic_colors.dart';

class DynamicText extends StatelessWidget {
  final TextProperties textProperties;
  final VoidCallback? callback;

  const DynamicText(
      {super.key, required this.textProperties, this.callback});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
        onTap: callback,
        child: Text(textProperties.text,
            style: TextStyle(
              fontSize: textProperties.textSize != null
                  ? double.tryParse(textProperties.textSize!)
                  : 16.0,
              color: DynamicColor.hexToColor(textProperties.textColorHex),
            )));
  }
}
