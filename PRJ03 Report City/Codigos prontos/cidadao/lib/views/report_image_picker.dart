import 'dart:io';

import 'package:cidadao/components/elevatedButton.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:image_picker/image_picker.dart';

class ReportImagePicker extends StatefulWidget {
  const ReportImagePicker({super.key});

  @override
  State<ReportImagePicker> createState() => _ReportImagePickerState();
}

class _ReportImagePickerState extends State<ReportImagePicker> {
  File? _image;
  bool isButtonDisabled = true;

  Future<void> _pickImage() async {
    final pickedFile =
        await ImagePicker().pickImage(source: ImageSource.camera);

    if (pickedFile != null) {
      setState(() {
        _image = File(pickedFile.path);
        isButtonDisabled = false;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    final screenSize = MediaQuery.of(context).size;

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
              child: Center(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    _image == null
                        ? SizedBox(
                            width: screenSize.width * 0.80,
                            height: screenSize.height * 0.80,
                            child: Center(
                              child: Text(
                                'Nenhuma foto selecionada.',
                                textAlign: TextAlign.center,
                              ),
                            ),
                          )
                        : Image.file(
                            _image!,
                            width: screenSize.width * 0.80,
                            height: screenSize.height * 0.80,
                            fit: BoxFit.contain,
                          ),
                    SizedBox(height: 20),
                    OutlinedButton(
                      onPressed: _pickImage,
                      style: ButtonStyle(
                        alignment: Alignment.center,
                        fixedSize: WidgetStatePropertyAll(
                          Size(screenSize.width, 50.h),
                        ),
                        overlayColor: WidgetStatePropertyAll(
                          Theme.of(context).colorScheme.primary.withValues(
                              alpha:
                                  0.2), // Usando a cor primária com opacidade
                        ),
                      ),
                      child: Text(
                        "Tirar uma Foto",
                        style: GoogleFonts.montserrat(
                          fontSize: 16.sp,
                          color: Theme.of(context)
                              .colorScheme
                              .primary, // Usando a cor primária do tema          fontWeight: FontWeight.w500,
                          fontWeight: FontWeight.w500,
                          height: 1.5.h,
                        ),
                        textAlign: TextAlign.center,
                      ),
                    ),
                    SizedBox(height: 8),
                    ElevatedButtonWidget(
                      callback: isButtonDisabled
                          ? null
                          : () {
                              Navigator.pop(context, _image);
                            },
                      width_: screenSize.width,
                      height_: 50.h,
                      label: "Usar essa Foto",
                    )
                  ],
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
