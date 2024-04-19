class DynamicAnalyticsProperties {
  final String? category;
  final String? action;
  final String? label;
  final String? track;

  const DynamicAnalyticsProperties(
      {this.category, this.label, this.action, this.track});

  factory DynamicAnalyticsProperties.fromJson(dynamic properties) {
    return DynamicAnalyticsProperties(
      category: properties != null ? properties["category"] : null,
      action: properties != null ? properties["action"] : null,
      label: properties != null ? properties["label"] : null,
      track: properties != null ? properties["track"] : null,
    );
  }

  static String key = "analytics";
}
