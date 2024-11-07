import 'package:flutter/material.dart';
import 'package:servico_terceirizado/views/detailedReport.dart';
import 'package:servico_terceirizado/views/forgotPassword.dart';
import 'package:servico_terceirizado/views/homePage.dart';
import 'package:servico_terceirizado/views/login.dart';
import 'package:servico_terceirizado/views/passwordRecovery.dart';

class RouteGenerator {
  static Route<dynamic> generateRoute(RouteSettings settings) {
    switch (settings.name) {
      case "/":
        return MaterialPageRoute(builder: (_) => const Login());
      case "/recoverySMS":
        return MaterialPageRoute(builder: (_) => const ForgotPasswordSMS());
      case "/changePassword":
        return MaterialPageRoute(builder: (_) => const ChangePassword());
      case "/home":
        return MaterialPageRoute(builder: (_) => const HomePage());
      case "/detailedReport":
        return MaterialPageRoute(
          builder: (_) {
            var args = settings.arguments as List;
            return DetailedReport(
              reportInfo: args[0].toString(),
            );
          },
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
