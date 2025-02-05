import 'dart:convert';
import 'dart:io';
import 'package:cidadao/components/elevatedButton.dart';
import 'package:cidadao/components/textFormField.dart';
import 'package:cidadao/functions/retreive_cache.dart';
import 'package:cidadao/main.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:get/get.dart' hide Response, FormData, MultipartFile;
import 'package:dio/dio.dart';

class Report extends StatefulWidget {
  const Report({super.key});

  @override
  State<Report> createState() => _ReportState();
}

class ReportType {
  final String type;

  ReportType({required this.type});
}

List<ReportType> reportsType = [
  ReportType(type: "BURACO NA VIA"),
  ReportType(type: "BURACO NA CALÇADA"),
  ReportType(type: "POSTE DANIFICADO"),
  ReportType(type: "ÁRVORE CAÍDA"),
  ReportType(type: "REDE ELÉTRICA DANIFICADA"),
];

class _ReportState extends State<Report> {
  final _reportFormKey = GlobalKey<FormState>();

  final TextEditingController _titleController = TextEditingController();
  final TextEditingController _descriptionController = TextEditingController();

  var geolocation;
  File? _reportImage;

  @override
  void dispose() {
    // Clean up the controller when the widget is disposed.
    _titleController.dispose();
    _descriptionController.dispose();

    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final screenSize = MediaQuery.of(context).size;

    ReportType? selectedType;
    return Scaffold(
      resizeToAvoidBottomInset: false,
      backgroundColor: const Color(0xFFEFEFEF),
      body: SafeArea(
        child: Padding(
          padding: EdgeInsets.symmetric(
            vertical: 8.h,
            horizontal: 8.w,
          ),
          child: SingleChildScrollView(
            child: IntrinsicHeight(
              child: Column(
                children: [
                  SizedBox(
                    height: 50.h,
                  ),
                  Align(
                    alignment: Alignment.centerLeft,
                    child: Text.rich(
                      TextSpan(
                        style: GoogleFonts.montserrat(
                          fontSize: 24.0.sp,
                          color: const Color(0xFF262624),
                          height: 1.16.h,
                        ),
                        children: const [
                          TextSpan(
                            text: 'Realizar uma',
                          ),
                          TextSpan(
                            text: ' ',
                          ),
                          TextSpan(
                            text: 'Denúncia',
                            style: TextStyle(
                              fontWeight: FontWeight.w600,
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),
                  Container(
                    height: 50.h,
                  ),
                  Center(
                    child: InkWell(
                      onTap: () async {
                        final imagePicked =
                            await Navigator.pushNamed(context, "/report_image");
                        print(imagePicked);
                        if (imagePicked is File) {
                          setState(() {
                            _reportImage = File(imagePicked.path);
                          });
                        }
                      },
                      child: _reportImage == null
                          ? Container(
                              height: 351.h,
                              width: 254.w,
                              decoration: BoxDecoration(
                                color: Colors.black,
                                borderRadius: BorderRadius.circular(
                                  8.r,
                                ),
                                boxShadow: [
                                  BoxShadow(
                                    blurRadius: 3.r,
                                    color: Colors.black,
                                    spreadRadius: 0.5.r,
                                    blurStyle: BlurStyle.solid,
                                  ),
                                ],
                              ),
                              child: Align(
                                alignment: Alignment.center,
                                child: Icon(
                                  Icons.add,
                                  color: Colors.white,
                                  size: 75.sp,
                                ),
                              ),
                            )
                          // : Container(),
                          : Image.file(
                              _reportImage!,
                              height: 351.h,
                              width: 254.w,
                              fit: BoxFit.contain,
                            ),
                    ),
                  ),
                  SizedBox(
                    height: 50.h,
                  ),
                  Form(
                    child: Flex(
                      direction: Axis.vertical,
                      children: [
                        DropdownMenu<ReportType>(
                          initialSelection: reportsType[0],
                          dropdownMenuEntries: [
                            for (var tipos in reportsType)
                              DropdownMenuEntry(label: tipos.type, value: tipos)
                          ],
                          width: screenSize.width,
                          onSelected: (ReportType? type) {
                            setState(() {
                              selectedType = type;
                            });
                          },
                        ),
                        SizedBox(
                          height: 8.h,
                        ),
                        TextFormFieldWidget(
                          textFormFieldController: _titleController,
                          formKey: _reportFormKey,
                          callback: (value) {
                            if (value.isEmpty) {
                              return "Insira o título da denúncia";
                            }

                            return null;
                          },
                          label: "Título",
                          maxLines: 1,
                          textInputType: TextInputType.text,
                          isObscure: false,
                          textInputAction: TextInputAction.next,
                          textInputFormatter: [
                            LengthLimitingTextInputFormatter(64)
                          ],
                          maxLengthEnforced: MaxLengthEnforcement.enforced,
                          isEnabled: true,
                        ),
                        SizedBox(
                          height: 8.h,
                        ),
                        TextFormFieldWidget(
                          textFormFieldController: _descriptionController,
                          formKey: _reportFormKey,
                          callback: (value) {
                            if (value.isEmpty) {
                              return "Insira a descrição da denúncia. Forneça mais informações sobre o problema que está sendo reportado.";
                            }

                            return null;
                          },
                          label: "Descrição",
                          maxLines: 4,
                          textInputType: TextInputType.text,
                          isObscure: false,
                          textInputAction: TextInputAction.done,
                          textInputFormatter: [
                            LengthLimitingTextInputFormatter(255)
                          ],
                          maxLengthEnforced: MaxLengthEnforcement.enforced,
                          isEnabled: true,
                        ),
                      ],
                    ),
                  ),
                  SizedBox(
                    height: 30.h,
                  ),
                  ElevatedButtonWidget(
                      callback: () async {
                        if (_reportFormKey.currentState!.validate()) {
                          geolocation = await determinePosition();

                          var latitude = geolocation.latitude;
                          var longitude = geolocation.longitude;

                          while (latitude == 00.0000000 &&
                              longitude == 00.000000) {
                            geolocation = await determinePosition();
                            latitude = geolocation.latitude;
                            longitude = geolocation.longitude;
                          }

                          Uint8List bytes;
                          try {
                            bytes = await _reportImage!.readAsBytes();
                            String base64String = base64Encode(bytes);

                            final publicId = getData('public_id');

                            Response<dynamic> response = await Dio().post(
                              "https://reportcity.ddns.net:3333/cliente/denuncia/$publicId",
                              data: {
                                'latitude': latitude,
                                'longitude': longitude,
                                'imageBase64': base64String,
                                'titulo': _titleController.text,
                                'descricao': _descriptionController.text,
                                'tipo': selectedType
                              },
                              options: Options(
                                responseType: ResponseType.json,
                              ),
                            );

                            if (response.statusCode == 200) {
                              Navigator.popAndPushNamed(context, "/home");
                            }
                          } catch (err) {}

                          Navigator.pop(context);
                        } else {
                          ScaffoldMessenger.of(context).showSnackBar(
                            const SnackBar(
                              content: Text(
                                'Insira os seus dados corretamente!',
                              ),
                            ),
                          );
                        }
                      },
                      width_: screenSize.width,
                      height_: 50.h,
                      label: "Enviar Denúncia"),
                  SizedBox(
                    height: 8.h,
                  ),
                  Padding(
                    padding: EdgeInsets.only(
                      bottom: MediaQuery.of(context).viewInsets.bottom,
                    ),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
