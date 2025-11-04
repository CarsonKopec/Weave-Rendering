package dev.jkit.ionview.render.style;

public sealed interface Fill permits SolidFill, GradientFill, PatternFill {}

public record SolidFill(Color color) implements Fill {}
public record GradientFill(Gradient gradient) implements Fill {}
public record PatternFill(ImageSource image) implements Fill {}

