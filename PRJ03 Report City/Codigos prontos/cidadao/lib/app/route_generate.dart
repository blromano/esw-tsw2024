import 'package:cidadao/views/mfa_recovery_password.dart';
import 'package:cidadao/views/new_password.dart';
import 'package:cidadao/views/recovery_password.dart';
import 'package:cidadao/views/home.dart';
import 'package:cidadao/views/login.dart';
import 'package:cidadao/views/logon.dart';
import 'package:cidadao/views/update_profile.dart';
import 'package:flutter/material.dart';

class RouteGenerator {
  static Route<dynamic> generateRoute(RouteSettings settings) {
    switch (settings.name) {
      case "/":
        return MaterialPageRoute(
          builder: (_) => const Login(),
        );
      case "/recovery_password":
        return MaterialPageRoute(
          builder: (_) => RecoveryPassword(email: settings.arguments as String),
        );
      case "/mfa_recovery_password":
        return MaterialPageRoute(
          builder: (_) =>
              MFARecoveryPassword(email: settings.arguments as String),
        );
      case "/new_password":
        return MaterialPageRoute(
          builder: (_) => const NewPassword(),
        );
      case "/logon":
        return MaterialPageRoute(
          builder: (_) => const Logon(),
        );
      case "/home":
        return MaterialPageRoute(
          builder: (_) => const Home(),
        );
      case "/update_profile":
        return MaterialPageRoute(
          builder: (_) => const UpdateProfile(),
        );
      default:
        return _erroRota();
    }
  }

  static Route<dynamic> _erroRota() {
    return MaterialPageRoute(
      builder: (_) {
        return Scaffold(
          appBar: AppBar(
            title: const Text("Tela não encontrada"),
          ),
          body: const Center(
            child: Text("Tela não encontrada"),
          ),
        );
      },
    );
  }
}
