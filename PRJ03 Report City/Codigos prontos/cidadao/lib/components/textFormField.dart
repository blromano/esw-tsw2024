import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:google_fonts/google_fonts.dart';

class TextFormFieldWidget extends StatefulWidget {
  final TextEditingController textFormFieldController;
  final GlobalKey<FormState> formKey;
  final callback;
  final String label;
  final int maxLines;
  final TextInputType textInputType;
  final bool isObscure;
  //final double scrollPaddingHeight;
  final TextInputAction textInputAction;
  final List<TextInputFormatter>? textInputFormatter;
  final onEditComplete;
  final int? maxLength;
  final MaxLengthEnforcement maxLengthEnforced;
  final bool isEnabled;

  const TextFormFieldWidget({
    super.key,
    required this.textFormFieldController,
    required this.formKey,
    required this.callback,
    required this.label,
    required this.maxLines,
    required this.textInputType,
    required this.isObscure,
    //required this.scrollPaddingHeight,
    required this.textInputAction,
    this.textInputFormatter,
    this.onEditComplete,
    /*required*/ this.maxLength,
    required this.maxLengthEnforced,
    required this.isEnabled,
  });

  @override
  State<TextFormFieldWidget> createState() => _TextFormFieldWidgetState();
}

class _TextFormFieldWidgetState extends State<TextFormFieldWidget> {
  // bool _showPassword = false;

  // void _togglevisibility() {
  //   setState(() {
  //     _showPassword = !_showPassword;
  //   });
  // }

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      // scrollPadding: EdgeInsets.symmetric(
      //   vertical: scrollPaddingHeight,
      // ),
      enabled: widget.isEnabled,
      autovalidateMode: AutovalidateMode.onUnfocus,
      inputFormatters: widget.textInputFormatter,
      controller: widget.textFormFieldController,
      maxLines: widget.maxLines,
      keyboardType: widget.textInputType,
      cursorColor: const Color(0xFF3A6642),
      validator: widget.callback,
      obscureText: widget.isObscure,
      textInputAction: widget.textInputAction,
      onEditingComplete: widget.onEditComplete,
      maxLength: widget.maxLength,
      maxLengthEnforcement: widget.maxLengthEnforced,
      style: GoogleFonts.inter(
        fontSize: 17.sp,
        color: const Color(0xFF37623A),
        fontWeight: FontWeight.w500,
      ),
      decoration: InputDecoration(
        // suffix: widget.isObscure == true
        //     ? GestureDetector(
        //         onTap: () {
        //           _togglevisibility();
        //         },
        //         child: Icon(
        //           _showPassword ? Icons.visibility : Icons.visibility_off,
        //           color: const Color(0xFF37623A),
        //         ),
        //       )
        //     : null,
        labelText: widget.label,
        labelStyle: GoogleFonts.inter(
          fontSize: 12.sp,
          color: const Color(0xFF8b8a84),
        ),
        disabledBorder: OutlineInputBorder(
          borderSide: const BorderSide(
            color: Color(0xFF8b8a84),
          ),
          borderRadius: BorderRadius.all(
            Radius.circular(16.r),
          ),
        ),
        enabledBorder: OutlineInputBorder(
          borderSide: const BorderSide(
            color: Color(0xFF3A6642),
          ),
          borderRadius: BorderRadius.all(
            Radius.circular(16.r),
          ),
        ),
        focusedBorder: OutlineInputBorder(
          borderSide: const BorderSide(
            color: Color(0xFF3A6642),
          ),
          borderRadius: BorderRadius.all(
            Radius.circular(16.r),
          ),
        ),
        errorBorder: OutlineInputBorder(
          borderSide: const BorderSide(
            color: Color(0xFFbc6262),
          ),
          borderRadius: BorderRadius.all(
            Radius.circular(16.r),
          ),
        ),
        focusedErrorBorder: OutlineInputBorder(
          borderSide: const BorderSide(
            color: Color(0xFFbc6262),
          ),
          borderRadius: BorderRadius.all(
            Radius.circular(16.r),
          ),
        ),
      ),
    );
  }
}
