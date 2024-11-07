import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:google_fonts/google_fonts.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class Denuncias {
  /// Id
  /// Titulo
  /// Descrição
  /// Imagens
  /// Status
  ///
  int? id;
  String? titulo;
  String? descricao;
  List<String>? imagens;
  String? status;

  Denuncias({
    this.id,
    this.titulo,
    this.descricao,
    this.imagens,
    this.status,
  });

  Denuncias.fromJson(Map<String, dynamic> json) {
    id = json["id"];
    titulo = json["titulo"];
    descricao = json["descricao"];
    imagens = json["imagens"];
    status = json["status"];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['id'] = id;
    data['titulo'] = titulo;
    data['descricao'] = descricao;
    data['imagens'] = imagens;
    data['status'] = status;
    return data;
  }
}

class _HomePageState extends State<HomePage> {
  Future<List<Denuncias>> fetchDenuncias() async {
    final String response = await rootBundle.loadString('assets/fakedata.json');
    final List denuncias = json.decode(response)["denuncias"];

    return denuncias.map((e) => Denuncias.fromJson(e)).toList();
  }

  @override
  Widget build(BuildContext context) {
    final size = MediaQuery.of(context).size;

    return Scaffold(
      resizeToAvoidBottomInset: false,
      backgroundColor: const Color(0xFFDCDCDA),
      body: SafeArea(
        child: Padding(
          padding: EdgeInsets.symmetric(
            horizontal: 8.w,
            vertical: 16.h,
          ),
          child: RefreshIndicator(
            onRefresh: () => Future.delayed(
              const Duration(seconds: 1),
            ),
            child: CustomScrollView(
              scrollDirection: Axis.vertical,
              shrinkWrap: true,
              slivers: [
                SliverFillRemaining(
                  hasScrollBody: false,
                  child: Center(
                    child: Flex(
                      direction: Axis.vertical,
                      children: <Widget>[
                        GestureDetector(
                          onTap: () {
                            print("Tap");
                            Navigator.pushNamed(context, "/detailedReport",
                                arguments: ["0"]);
                          },
                          child: Container(
                            width: size.width,
                            margin: EdgeInsets.symmetric(
                              horizontal: 0.w,
                              vertical: 4.h,
                            ),
                            decoration: BoxDecoration(
                              boxShadow: [
                                BoxShadow(
                                  color:
                                      const Color(0xFF494845).withOpacity(0.3),
                                  spreadRadius: 3,
                                  blurRadius: 5,
                                  offset: const Offset(0, 3),
                                ),
                              ],
                              borderRadius: BorderRadius.circular(
                                24.r,
                              ),
                              color: const Color(0xFFcee4d2),
                            ),
                            child: Padding(
                              padding: EdgeInsets.symmetric(
                                horizontal: 8.w,
                                vertical: 8.h,
                              ),
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(
                                    "Buraco na Rua São João",
                                    style: GoogleFonts.inter(
                                      fontSize: 26.sp,
                                      fontWeight: FontWeight.w600,
                                      color: const Color(0xFF122115),
                                    ),
                                  ),
                                  SizedBox(
                                    height: 4.h,
                                  ),
                                  Text(
                                    "Rua repleta de buracos que oferecem riscos aos veículos que transitam por ela.",
                                    style: GoogleFonts.inter(
                                      fontSize: 12.sp,
                                      fontWeight: FontWeight.w600,
                                      color: const Color(0xFF122115),
                                    ),
                                  ),
                                  SizedBox(
                                    height: 4.h,
                                  ),
                                  Flex(
                                    direction: Axis.horizontal,
                                    children: [
                                      ClipRRect(
                                        borderRadius:
                                            BorderRadius.circular(24.r),
                                        child: Image.asset(
                                          'assets/buraco1.jpeg',
                                          width: 100.w,
                                          height: 150.h,
                                          fit: BoxFit.fill,
                                        ),
                                      ),
                                      SizedBox(
                                        width: 8.w,
                                      ),
                                      ClipRRect(
                                        borderRadius:
                                            BorderRadius.circular(24.r),
                                        child: Image.asset(
                                          'assets/buraco2.jpeg',
                                          width: 100.w,
                                          height: 150.h,
                                          fit: BoxFit.fill,
                                        ),
                                      ),
                                    ],
                                  ),
                                  SizedBox(
                                    height: 4.h,
                                  ),
                                  SizedBox(
                                    width: size.width,
                                    child: const Text(
                                      "Visualizar denuncia",
                                      textAlign: TextAlign.right,
                                    ),
                                  ),
                                ],
                              ),
                            ),
                          ),
                        ),
                        GestureDetector(
                          onTap: () {
                            print("Tap");
                            Navigator.pushNamed(context, "/detailedReport2",
                                arguments: ["0"]);
                          },
                          child: Container(
                            margin: EdgeInsets.symmetric(
                              horizontal: 0.w,
                              vertical: 4.h,
                            ),
                            width: size.width,
                            decoration: BoxDecoration(
                              boxShadow: [
                                BoxShadow(
                                  color:
                                      const Color(0xFF494845).withOpacity(0.3),
                                  spreadRadius: 3,
                                  blurRadius: 5,
                                  offset: const Offset(0, 3),
                                ),
                              ],
                              borderRadius: BorderRadius.circular(
                                24.r,
                              ),
                              color: const Color(0xFFcee4d2),
                            ),
                            child: Padding(
                              padding: EdgeInsets.symmetric(
                                horizontal: 8.w,
                                vertical: 8.h,
                              ),
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(
                                    "Calçada quebrada",
                                    style: GoogleFonts.inter(
                                      fontSize: 26.sp,
                                      fontWeight: FontWeight.w600,
                                      color: const Color(0xFF122115),
                                    ),
                                  ),
                                  SizedBox(
                                    height: 4.h,
                                  ),
                                  Text(
                                    "Calçada da Rua Coronal José Procópio está toda quebrada por conta das arvores.",
                                    style: GoogleFonts.inter(
                                      fontSize: 12.sp,
                                      fontWeight: FontWeight.w600,
                                      color: const Color(0xFF122115),
                                    ),
                                  ),
                                  SizedBox(
                                    height: 4.h,
                                  ),
                                  SizedBox(
                                    width: size.width,
                                    child: const Text(
                                      "Visualizar denuncia",
                                      textAlign: TextAlign.right,
                                    ),
                                  ),
                                ],
                              ),
                            ),
                          ),
                        ),
                      ],
                    ),
                  ),
                  // child: Center(
                  //   child: FutureBuilder(
                  //     future: fetchDenuncias(),
                  //     builder: (context, snapshot) {
                  //       if (snapshot.hasData) {
                  //         return ListView.builder(
                  //           shrinkWrap: true,
                  //           itemCount: snapshot.data!.length,
                  //           itemBuilder: (context, index) {
                  //             print(snapshot.data);
                  //             return ReportCard(data: snapshot.data!);
                  //           },
                  //         );
                  //       } else if (snapshot.hasError) {
                  //         return Text('${snapshot.error}');
                  //       }
                  //       return const CircularProgressIndicator();
                  //     },
                  //   ),
                  // ),
                )
              ],
            ),
          ),
        ),
      ),
    );
  }
}
