import 'dart:convert';
import 'dart:io';

Future<String> convertToBase64(File foto) async {
  final bytes = await foto.readAsBytes();
  String base64String = base64Encode(bytes);

  return base64String;
}
