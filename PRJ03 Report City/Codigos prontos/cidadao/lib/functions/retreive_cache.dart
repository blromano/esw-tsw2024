import 'package:shared_preferences/shared_preferences.dart';

Future<String?> getData(String key) async {
  final prefs = await SharedPreferences.getInstance();
  return prefs.getString(key);
}
