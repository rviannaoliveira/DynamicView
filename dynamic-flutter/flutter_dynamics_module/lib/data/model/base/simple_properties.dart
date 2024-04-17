import 'package:flutter_dynamics_module/presentation/builder/dynamic_builders.dart';

import '../../../presentation/builder/dynamic_builder.dart';

class SimpleProperties {
  final String key;
  final dynamic value;

  const SimpleProperties({required this.key, this.value});

  factory SimpleProperties.fromJson(dynamic properties) {
    String key = properties["key"];
    DynamicBuilder builder = DynamicBuilders.getBuilder(key);

    return SimpleProperties(
        key: key, value: builder.fromJson(properties["value"]));
  }
}
