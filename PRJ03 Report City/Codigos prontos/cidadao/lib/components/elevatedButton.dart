import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:google_fonts/google_fonts.dart';

class ElevatedButtonWidget extends StatelessWidget {
  const ElevatedButtonWidget({
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
    return ElevatedButton(
      onPressed: callback,
      style: ButtonStyle(
        alignment: Alignment.center,
        fixedSize: WidgetStatePropertyAll(
          Size(width_, height_),
        ),
        backgroundColor: const WidgetStatePropertyAll(
          Color(0xFF3a6642),
        ),
        overlayColor: WidgetStatePropertyAll(
          const Color(0xFFa6cfad).withOpacity(0.2),
        ),
      ),
      child: Text(
        label,
        style: GoogleFonts.inter(
          fontSize: 16.sp,
          color: const Color(0xFFf6f6f6),
          fontWeight: FontWeight.w600,
          height: 1.5.h,
        ),
        textAlign: TextAlign.center,
      ),
    );
  }
}
