library flutter_dynamics_module;

import 'package:flutter/material.dart';
import 'package:flutter_dynamics_module/presentation/dynamic_view_listener.dart';

abstract class DynamicBuilder<T> {
  const DynamicBuilder({required String key});

  T fromJson(dynamic properties);

  Widget craft(T model, DynamicViewListener listener);
}
