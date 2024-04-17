import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_dynamics_module/data/model/empty/empty_properties.dart';
import 'package:flutter_dynamics_module/presentation/builder/dynamic_builder.dart';
import 'package:flutter_dynamics_module/presentation/dynamic_view_listener.dart';
import 'package:flutter_dynamics_module/presentation/ui/button/dynamic_button.dart';
import 'package:flutter_dynamics_module/presentation/ui/empty/dynamic_empty.dart';

import '../../../data/model/button/button_properties.dart';

class DynamicEmptyBuilder extends DynamicBuilder<EmptyProperties> {
  DynamicEmptyBuilder() : super(key: "dynamicEmpty");

  @override
  Widget craft(EmptyProperties model, DynamicViewListener listener) {
    return const DynamicEmpty();
  }

  @override
  EmptyProperties fromJson(properties) {
    return const EmptyProperties();
  }
  static String key = "dynamicEmpty";
}