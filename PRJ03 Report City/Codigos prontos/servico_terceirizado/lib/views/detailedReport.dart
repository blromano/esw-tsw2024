import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:maps_launcher/maps_launcher.dart';

class DetailedReport extends StatefulWidget {
  const DetailedReport({super.key, required reportInfo});

  @override
  State<DetailedReport> createState() => _DetailedReportState();
}

class _DetailedReportState extends State<DetailedReport> {
  final TextEditingController _feedbackController = TextEditingController();

  @override
  void dispose() {
    // Clean up the controller when the widget is disposed.
    _feedbackController.dispose();
    super.dispose();
  }

  List<String> tiposDenuncia = [
    "Em andamento",
    "Concluído",
    "Cancelado",
    "Em análise"
  ];

  String? denunciaAtual;

  @override
  void setState(VoidCallback fn) {
    denunciaAtual = tiposDenuncia[3].toString();
    super.setState(fn);
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
              keyboardDismissBehavior: ScrollViewKeyboardDismissBehavior.manual,
              slivers: [
                SliverFillRemaining(
                  hasScrollBody: false,
                  child: Flex(
                    direction: Axis.vertical,
                    children: [
                      Expanded(
                        flex: 1,
                        child: Column(
                          children: [
                            SizedBox(
                              width: size.width,
                              child: Text(
                                "Buraco na Rua São João",
                                style: GoogleFonts.inter(
                                  fontSize: 24.0.sp,
                                  color: const Color(0xFF122115),
                                  height: 1.45.h,
                                  fontWeight: FontWeight.w600,
                                ),
                              ),
                            ),
                            Align(
                              alignment: Alignment.centerLeft,
                              child: DropdownButton(
                                dropdownColor: const Color(0xFFe6f2e8),
                                underline: Container(),
                                value: denunciaAtual,
                                items: [
                                  for (String preset in tiposDenuncia)
                                    DropdownMenuItem(
                                      value: preset,
                                      child: Text(
                                        preset.toString().toUpperCase(),
                                        style: const TextStyle(
                                            color: Color(0xFF3a6642)),
                                      ),
                                    )
                                ],
                                onChanged: (value) {
                                  setState(() {
                                    denunciaAtual = value!.toString();
                                  });
                                },
                                hint: Text(
                                  "Selecione o Status".toUpperCase(),
                                  style: GoogleFonts.inter(
                                      color: const Color(0xFF3a6642)),
                                ),
                              ),
                            ),
                          ],
                        ),
                      ),
                      Expanded(
                        flex: 10,
                        child: Container(
                          width: size.width,
                          padding: EdgeInsets.symmetric(
                            horizontal: 8.w,
                            vertical: 16.h,
                          ),
                          decoration: BoxDecoration(
                            boxShadow: [
                              BoxShadow(
                                color: const Color(0xFF494845).withOpacity(0.3),
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
                          child: Column(
                            children: [
                              Row(
                                mainAxisAlignment:
                                    MainAxisAlignment.spaceAround,
                                children: [
                                  ClipRRect(
                                    borderRadius: BorderRadius.circular(24.r),
                                    child: Image.asset(
                                      'assets/buraco1.jpeg',
                                      width: (100 * 1.9).w,
                                      height: (150 * 1.9).h,
                                      fit: BoxFit.fill,
                                    ),
                                  ),
                                  ClipRRect(
                                    borderRadius: BorderRadius.circular(24.r),
                                    child: Image.asset(
                                      'assets/buraco2.jpeg',
                                      width: (100 * 1.9).w,
                                      height: (150 * 1.9).h,
                                      fit: BoxFit.fill,
                                    ),
                                  ),
                                ],
                              ),
                              Container(
                                width: size.width,
                                margin: EdgeInsets.only(
                                  top: 4.h,
                                  bottom: 4.h,
                                ),
                                child: Text(
                                  "Rua repleta de buracos que oferecem riscos aos veículos que transitam por ela.",
                                  style: GoogleFonts.inter(
                                    fontSize: 16.0.sp,
                                    color: const Color(0xFF2e4d34),
                                    height: 1.45.h,
                                    fontWeight: FontWeight.w600,
                                  ),
                                ),
                              ),
                              SizedBox(
                                height: 8.h,
                              ),
                              ElevatedButton(
                                onPressed: () {
                                  MapsLauncher.launchCoordinates(
                                      -21.967190, -46.799357);
                                },
                                style: ButtonStyle(
                                  alignment: Alignment.center,
                                  fixedSize: WidgetStatePropertyAll(
                                    Size(size.width, 50.h),
                                  ),
                                  backgroundColor: const WidgetStatePropertyAll(
                                    Color(0xFF3a6642),
                                  ),
                                  overlayColor: WidgetStatePropertyAll(
                                    const Color(0xFFa6cfad).withOpacity(0.2),
                                  ),
                                ),
                                child: Text(
                                  "Abrir no Maps!",
                                  style: GoogleFonts.inter(
                                    fontSize: 16.sp,
                                    color: const Color(0xFFf6f6f6),
                                    fontWeight: FontWeight.w600,
                                    height: 1.5.h,
                                  ),
                                  textAlign: TextAlign.center,
                                ),
                              )
                            ],
                          ),
                        ),
                      )
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
