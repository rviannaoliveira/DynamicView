import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_dynamics/main_state.dart';
import 'package:flutter_dynamics_module/data/model/base/simple_properties.dart';
import 'package:flutter_dynamics_module/presentation/builder/dynamic_builders.dart';
import 'package:flutter_mobx/flutter_mobx.dart';

import 'main_controller.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Dynamics'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  late MainController _controller;

  @override
  void initState() {
    super.initState();
    _controller = MainController();
    _controller.loadProperties(context);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text(widget.title),
        ),
        body: Center(child: Observer(builder: (_) {
          switch (_controller.state.runtimeType) {
            case MainLoadingState:
              return const CircularProgressIndicator();
            case MainErrorState:
              return Text(_controller.state.toStateError().msg);
            case MainSuccessState:
              final properties = _controller.state.toStateSuccess().properties;
              return ListView.builder(
                  itemCount: properties.length,
                  itemBuilder: (context, index) {
                    final SimpleProperties simpleProperties = properties[index];
                    final dynamicBuilder =
                        DynamicBuilders.getBuilder(simpleProperties.key);
                    return dynamicBuilder
                        .craft(dynamicBuilder.fromJson(simpleProperties.value),
                            (actionProperties) {
                      print(
                          "categoria ${actionProperties.analyticsProperties?.category} "
                          "label ${actionProperties.analyticsProperties?.label} - "
                          "track ${actionProperties.analyticsProperties?.track}");
                    });
                  });
          }
          return Container();
        })));
  }
}
