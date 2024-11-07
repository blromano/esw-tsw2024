import 'package:flutter/material.dart';
import 'package:flutter_pw_validator/Resource/Strings.dart';
import 'package:flutter_pw_validator/flutter_pw_validator.dart';

class PasswordValidator extends StatefulWidget {
  final GlobalKey<FlutterPwValidatorState> validatorStateKey;
  final double width;
  final double height;
  final onSuccessCallback;
  final onFailureCallback;
  final TextEditingController passwordController;
  final int minLength;

  const PasswordValidator({
    super.key,
    required this.validatorStateKey,
    required this.width,
    required this.height,
    required this.onSuccessCallback,
    required this.onFailureCallback,
    required this.passwordController,
    required this.minLength,
  });

  @override
  State<PasswordValidator> createState() => _PasswordValidatorState();
}

class PortugueseStrings implements FlutterPwValidatorStrings {
  @override
  final String atLeast = 'Ao menos - caracteres';
  @override
  final String uppercaseLetters = '- Letras maiúsculas';
  @override
  final String numericCharacters = '- Números';
  @override
  final String specialCharacters = '- Caracteres especiais';
  @override
  final String lowercaseLetters = '- Letras minúsculas';
  @override
  final String normalLetters = '- Caracteres normais';
}

class _PasswordValidatorState extends State<PasswordValidator> {
  @override
  Widget build(BuildContext context) {
    return FlutterPwValidator(
      key: widget.validatorStateKey,
      controller: widget.passwordController,
      width: widget.width,
      height: widget.height,
      minLength: widget.minLength,
      onSuccess: widget.onSuccessCallback,
      onFail: widget.onFailureCallback,
      uppercaseCharCount: 1,
      numericCharCount: 2,
      specialCharCount: 1,
      failureColor: const Color(0xFFbc6262),
      successColor: const Color(0xFF3A6642),
      defaultColor: const Color(0xFF8b8a84),
      strings: PortugueseStrings(),
    );
  }
}

// FlutterPwValidator(
//                             key = _passwrodValidatorKey,
//                             width = screenSize.width,
//                             height = 150.h,
//                             minLength = 8,
//                             onSuccess = () {},
//                             onFail = () {},
//                             controller = _passwordController,
//                             uppercaseCharCount = 2,
//                             numericCharCount = 2,
//                             specialCharCount = 1,
//                             failureColor = const Color(0xFFbc6262),
//                             successColor = const Color(0xFF3A6642),
//                             defaultColor = const Color(0xFF8b8a84),
//                           ),
