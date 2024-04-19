import 'package:flutter/material.dart';
import 'package:flutter_dynamics_module/data/model/base/simple_properties.dart';
import '../../data/model/action/dynamic_action_properties.dart';
import '../builder/dynamic_builders.dart';

class DynamicController extends StatelessWidget {
  final List<SimpleProperties> simplePropertiesList;
  final Function(DynamicActionProperties) onAction;

  const DynamicController(
      {super.key, required this.simplePropertiesList, required this.onAction});

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        itemCount: simplePropertiesList.length,
        itemBuilder: (context, index) {
          final SimpleProperties simpleProperties = simplePropertiesList[index];
          final dynamicBuilder =
              DynamicBuilders.getBuilder(simpleProperties.key);
          return dynamicBuilder
              .craft(dynamicBuilder.fromJson(simpleProperties.value),
                  (actionProperties) {
            onAction(actionProperties);
          });
        });
  }
}
