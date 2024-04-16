import 'package:flutter/material.dart';

import '../../../data/model/button/button_properties.dart';


class DynamicButton extends StatelessWidget {
  final VoidCallback callback;
  final ButtonProperties buttonProperties;

  const DynamicButton(
      {super.key,
      required this.buttonProperties,
      required this.callback});

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: () {
        callback();
      },
      child: Text(buttonProperties.text),
    );
  }
}
