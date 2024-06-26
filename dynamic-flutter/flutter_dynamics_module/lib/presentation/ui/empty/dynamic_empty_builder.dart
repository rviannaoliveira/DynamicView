import 'package:flutter/material.dart';
import 'package:flutter_dynamics_module/data/model/empty/empty_properties.dart';
import 'package:flutter_dynamics_module/presentation/builder/dynamic_builder.dart';
import 'package:flutter_dynamics_module/presentation/dynamic_view_listener.dart';
import 'package:flutter_dynamics_module/presentation/ui/empty/dynamic_empty.dart';

class DynamicEmptyBuilder extends DynamicBuilder<EmptyProperties> {
  DynamicEmptyBuilder() : super(key: key);

  @override
  Widget craft(EmptyProperties model, DynamicViewListener listener) {
    return const DynamicEmpty();
  }

  @override
  EmptyProperties fromJson(properties) {
    return const EmptyProperties();
  }
  static String key = "DynamicEmpty";
}