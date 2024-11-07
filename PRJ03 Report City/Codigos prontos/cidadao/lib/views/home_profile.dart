import 'package:cidadao/components/elevatedButton.dart';
import 'package:cidadao/components/outlinedButton.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class HomeProfile extends StatefulWidget {
  const HomeProfile({super.key});

  @override
  State<HomeProfile> createState() => _HomeProfileState();
}

class _HomeProfileState extends State<HomeProfile> {
  @override
  Widget build(BuildContext context) {
    final screenSize = MediaQuery.of(context).size;

    return SafeArea(
      child: Stack(
        children: [
          Align(
            alignment: Alignment.topCenter,
            child: SizedBox(
              height: screenSize.height * 0.31,
              width: screenSize.width,
              child: Image.asset(
                "assets/placeholders/sjbv_placeholder.jpg",
                filterQuality: FilterQuality.high,
                fit: BoxFit.cover,
              ),
            ),
          ),
          Align(
            alignment: Alignment.bottomCenter,
            child: Container(
              height: screenSize.height * 0.60,
              width: screenSize.width,
              decoration: BoxDecoration(
                borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(32.r),
                  topRight: Radius.circular(32.r),
                ),
                boxShadow: [
                  BoxShadow(
                    blurRadius: 16.r,
                    color: const Color(0xFFcee4d2),
                    spreadRadius: 2.r,
                  ),
                ],
                color: const Color(0xFFDCDCDA),
              ),
              child: Padding(
                padding: EdgeInsets.fromLTRB(8.w, 20.h, 8.w, 8.h),
                child: SingleChildScrollView(
                  child: IntrinsicHeight(
                    child: Column(
                      children: [
                        Container(
                          height: 50.h,
                          width: screenSize.width,
                          margin: const EdgeInsets.symmetric(vertical: 4),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                "Nome:",
                                style: TextStyle(
                                  fontSize: 14.sp,
                                  fontWeight: FontWeight.w600,
                                ),
                                textAlign: TextAlign.start,
                              ),
                              Text(
                                "Henrique Bissoli Malaman Alonso",
                                style: TextStyle(
                                  fontSize: 18.sp,
                                  fontWeight: FontWeight.normal,
                                ),
                              )
                            ],
                          ),
                        ),
                        Container(
                          height: 50.h,
                          width: screenSize.width,
                          margin: const EdgeInsets.symmetric(vertical: 4),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                "CPF:",
                                style: TextStyle(
                                  fontSize: 14.sp,
                                  fontWeight: FontWeight.w600,
                                ),
                                textAlign: TextAlign.start,
                              ),
                              Text(
                                "38X.XXX.XXX-XX",
                                style: TextStyle(
                                  fontSize: 18.sp,
                                  fontWeight: FontWeight.normal,
                                ),
                              )
                            ],
                          ),
                        ),
                        Container(
                          height: 50.h,
                          width: screenSize.width,
                          margin: const EdgeInsets.symmetric(vertical: 4),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                "Celular:",
                                style: TextStyle(
                                  fontSize: 14.sp,
                                  fontWeight: FontWeight.w600,
                                ),
                                textAlign: TextAlign.start,
                              ),
                              Text(
                                "(19) 9 9712-1105",
                                style: TextStyle(
                                  fontSize: 18.sp,
                                  fontWeight: FontWeight.normal,
                                ),
                              )
                            ],
                          ),
                        ),
                        Container(
                          height: 50.h,
                          width: screenSize.width,
                          margin: const EdgeInsets.symmetric(vertical: 4),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                "E-mail:",
                                style: TextStyle(
                                  fontSize: 14.sp,
                                  fontWeight: FontWeight.w600,
                                ),
                                textAlign: TextAlign.start,
                              ),
                              Text(
                                "contato.henrique.bissoli@gmail.com",
                                style: TextStyle(
                                  fontSize: 18.sp,
                                  fontWeight: FontWeight.normal,
                                ),
                              )
                            ],
                          ),
                        ),
                        Container(
                          height: 50.h,
                          width: screenSize.width,
                          margin: const EdgeInsets.symmetric(vertical: 4),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                "CEP:",
                                style: TextStyle(
                                  fontSize: 14.sp,
                                  fontWeight: FontWeight.w600,
                                ),
                                textAlign: TextAlign.start,
                              ),
                              Text(
                                "13.874-439",
                                style: TextStyle(
                                  fontSize: 18.sp,
                                  fontWeight: FontWeight.normal,
                                ),
                              )
                            ],
                          ),
                        ),
                        Row(
                          children: [
                            Container(
                              height: 50.h,
                              width: screenSize.width * .75,
                              margin: const EdgeInsets.symmetric(vertical: 4),
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(
                                    "Rua:",
                                    style: TextStyle(
                                      fontSize: 14.sp,
                                      fontWeight: FontWeight.w600,
                                    ),
                                    textAlign: TextAlign.start,
                                  ),
                                  Text(
                                    "Rua Nagib Miguel",
                                    style: TextStyle(
                                      fontSize: 18.sp,
                                      fontWeight: FontWeight.normal,
                                    ),
                                  )
                                ],
                              ),
                            ),
                            Container(
                              height: 50.h,
                              width: screenSize.width * .20,
                              margin: const EdgeInsets.symmetric(vertical: 4),
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(
                                    "Número:",
                                    style: TextStyle(
                                      fontSize: 14.sp,
                                      fontWeight: FontWeight.w600,
                                    ),
                                    textAlign: TextAlign.start,
                                  ),
                                  Text(
                                    "4035",
                                    style: TextStyle(
                                      fontSize: 18.sp,
                                      fontWeight: FontWeight.normal,
                                    ),
                                  )
                                ],
                              ),
                            ),
                          ],
                        ),
                        Container(
                          height: 50.h,
                          width: screenSize.width,
                          margin: const EdgeInsets.symmetric(vertical: 4),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                "Complemento:",
                                style: TextStyle(
                                  fontSize: 14.sp,
                                  fontWeight: FontWeight.w600,
                                ),
                                textAlign: TextAlign.start,
                              ),
                              Text(
                                "Casa 360",
                                style: TextStyle(
                                  fontSize: 18.sp,
                                  fontWeight: FontWeight.normal,
                                ),
                              )
                            ],
                          ),
                        ),
                        Container(
                          height: 50.h,
                          width: screenSize.width,
                          margin: const EdgeInsets.symmetric(vertical: 4),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                "Bairro:",
                                style: TextStyle(
                                  fontSize: 14.sp,
                                  fontWeight: FontWeight.w600,
                                ),
                                textAlign: TextAlign.start,
                              ),
                              Text(
                                "Jardim Recanto do Bosque",
                                style: TextStyle(
                                  fontSize: 18.sp,
                                  fontWeight: FontWeight.normal,
                                ),
                              )
                            ],
                          ),
                        ),
                        Container(
                          height: 50.h,
                          width: screenSize.width,
                          margin: const EdgeInsets.symmetric(vertical: 4),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                "Cidade:",
                                style: TextStyle(
                                  fontSize: 14.sp,
                                  fontWeight: FontWeight.w600,
                                ),
                                textAlign: TextAlign.start,
                              ),
                              Text(
                                "São João da Boa Vista",
                                style: TextStyle(
                                  fontSize: 18.sp,
                                  fontWeight: FontWeight.normal,
                                ),
                              )
                            ],
                          ),
                        ),
                        Container(
                          height: 50.h,
                          width: screenSize.width,
                          margin: const EdgeInsets.symmetric(vertical: 4),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                "Estado:",
                                style: TextStyle(
                                  fontSize: 14.sp,
                                  fontWeight: FontWeight.w600,
                                ),
                                textAlign: TextAlign.start,
                              ),
                              Text(
                                "São Paulo",
                                style: TextStyle(
                                  fontSize: 18.sp,
                                  fontWeight: FontWeight.normal,
                                ),
                              )
                            ],
                          ),
                        ),
                        ElevatedButtonWidget(
                          callback: () {
                            Navigator.pushNamed(context, "/update_profile");
                          },
                          width_: screenSize.width,
                          height_: 50.h,
                          label: "Atualizar Cadastro",
                        ),
                        SizedBox(
                          height: 8.h,
                        ),
                        OutlinedButtonWidget(
                          callback: () {
                            Navigator.pushNamed(
                                context, "/mfa_recovery_password",
                                arguments:
                                    "contato.henrique.bissoli@gmail.com");
                          },
                          width_: screenSize.width,
                          height_: 50.h,
                          label: "Atualizar Senha",
                        )
                      ],
                    ),
                  ),
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
