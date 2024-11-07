import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:servico_terceirizado/app/route_generate.dart';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return ScreenUtilInit(
      //iPhone 14/15 Pro Max size
      designSize: const Size(430, 932),
      minTextAdapt: true,
      splitScreenMode: true,
      builder: (context, child) {
        return MaterialApp(
          debugShowCheckedModeBanner: false,
          debugShowMaterialGrid: false,
          title: "TiddyVille",
          theme: ThemeData(
            useMaterial3: true,
            // colorScheme: ColorScheme.fromSeed(
            //   seedColor: const Color(0xff82bd69),
            //   primary: const Color(0xff82bd69),
            //   secondary: const Color(0xff4c8435),
            //   surface: Colors.white,
            // ),
          ),
          initialRoute: "/",
          onGenerateRoute: RouteGenerator.generateRoute,
        );
      },
    );
  }
}

/*
  
    
  Verde Claro(#88bc64):
    '50': '#f3f8ed',
    '100': '#e3f0d7',
    '200': '#c8e2b4',
    '300': '#a6cf87',
    '400': '#88bc64',
    '500': '#679f43',
    '600': '#4f7e32',
    '700': '#3d612a',
    '800': '#354e26',
    '900': '#2e4423',
    '950': '#16240f',
  
  Cinza(#dcdcda): 
    '50': '#f6f6f6',
    '100': '#ebebe9',
    '200': '#dcdcda',
    '300': '#babab7',
    '400': '#9e9d99',
    '500': '#8b8a84',
    '600': '#7e7d78',
    '700': '#6a6964',
    '800': '#585754',
    '900': '#494845',
    '950': '#262624',

  Azul Escuro 1(#192C36):
    '50': '#f1f8fa',
    '100': '#dceff1',
    '200': '#bcdee5',
    '300': '#8ec6d2',
    '400': '#59a5b7',
    '500': '#3d899d',
    '600': '#357085',
    '700': '#315c6d',
    '800': '#2f4e5b',
    '900': '#2b434e',
    '950': '#192c36',
  
  Azul Escuro 2(#001a2b):
    '50': '#eef9ff',
    '100': '#dcf3ff',
    '200': '#b2e9ff',
    '300': '#6ddaff',
    '400': '#20c7ff',
    '500': '#00b0ff',
    '600': '#008ddf',
    '700': '#0070b4',
    '800': '#005f95',
    '900': '#004e7a',
    '950': '#001a2b',
    
*/
