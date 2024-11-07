import 'package:flutter/material.dart';

class TextButtonWidget extends StatelessWidget {
  const TextButtonWidget({
    super.key,
    required this.callback,
    required this.buttonStyle,
    required this.buttonText,
  });

  final callback;
  final Text buttonText;
  final ButtonStyle buttonStyle;

  @override
  Widget build(BuildContext context) {
    return TextButton(
      onPressed: callback,
      style: buttonStyle,
      child: buttonText,
    );
  }
}
