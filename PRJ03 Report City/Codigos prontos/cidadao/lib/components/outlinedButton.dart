import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:google_fonts/google_fonts.dart';

class OutlinedButtonWidget extends StatelessWidget {
  const OutlinedButtonWidget({
    super.key,
    required this.callback,
    required this.width_,
    required this.height_,
    required this.label,
  });

  final callback;
  final double width_;
  final double height_;
  final String label;

  @override
  Widget build(BuildContext context) {
    return OutlinedButton(
      onPressed: callback,
      style: ButtonStyle(
        alignment: Alignment.center,
        fixedSize: WidgetStatePropertyAll(
          Size(width_, height_),
        ),
        overlayColor: WidgetStatePropertyAll(
          const Color(0xFFa6cfad).withOpacity(0.2),
        ),
      ),
      child: Text(
        label,
        style: GoogleFonts.inter(
          fontSize: 16.sp,
          color: const Color(0xFF3a6642),
          fontWeight: FontWeight.w500,
          height: 1.5.h,
        ),
        textAlign: TextAlign.center,
      ),
    );
  }
}
