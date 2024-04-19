import 'dart:ui';
import 'package:flutter/material.dart';

class DynamicColor{
  static Color hexToColor(String? hexColor) {
    try{
      hexColor = hexColor!.replaceAll("#", "");
      if (hexColor.length == 6) {
        hexColor = "FF" + hexColor;
      }
      return Color(int.parse(hexColor, radix: 16));
    } catch (e) {
      return Colors.black;
    }
  }
}