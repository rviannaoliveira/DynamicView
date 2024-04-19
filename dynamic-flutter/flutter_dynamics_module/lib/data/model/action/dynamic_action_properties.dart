import 'dynamic_analytics_properties.dart';

class DynamicActionProperties {
  final String? deeplink;
  final DynamicAnalyticsProperties? analyticsProperties;

  const DynamicActionProperties({this.deeplink, this.analyticsProperties});

  factory DynamicActionProperties.fromJson(dynamic? properties) {
    return DynamicActionProperties(
        deeplink: properties != null ? properties["deeplink"] : null,
        analyticsProperties: properties != null ? DynamicAnalyticsProperties
            .fromJson(
            properties[DynamicAnalyticsProperties.key]) : null);
  }

  static const String key = "actionProperties";
}