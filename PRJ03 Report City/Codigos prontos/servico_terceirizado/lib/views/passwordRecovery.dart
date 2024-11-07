import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class ChangePassword extends StatefulWidget {
  const ChangePassword({super.key});

  @override
  State<ChangePassword> createState() => _ChangePasswordState();
}

class _ChangePasswordState extends State<ChangePassword> {
  final GlobalKey _changePasswordKey = GlobalKey<FormState>();
  final TextEditingController _passwordController = TextEditingController();
  final TextEditingController _passwordConfirmationController =
      TextEditingController();
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
            child: CustomScrollView(
              slivers: [
                SliverFillRemaining(
                  hasScrollBody: false,
                  child: Flex(
                    direction: Axis.vertical,
                    children: <Widget>[
                      Expanded(
                        flex: 2,
                        child: Align(
                          alignment: Alignment.centerLeft,
                          child: SizedBox(
                            width: size.width * 0.65,
                            child: welcomeText(),
                          ),
                        ),
                      ),
                      Expanded(
                        flex: 2,
                        child: Column(
                          children: <Widget>[
                            reportCityLogo(size.height / 5, size.height / 5),
                          ],
                        ),
                      ),
                      Expanded(
                        flex: 3,
                        child: Container(
                          width: size.width,
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
                          padding: EdgeInsets.symmetric(
                            vertical: 16.h,
                            horizontal: 8.w,
                          ),
                          child: Form(
                            key: _changePasswordKey,
                            autovalidateMode: AutovalidateMode.always,
                            child: Column(
                              children: [
                                Text.rich(
                                  TextSpan(
                                    style: GoogleFonts.inter(
                                      fontSize: 16.0.sp,
                                      color: const Color(0xFF010101),
                                      height: 1.45.h,
                                    ),
                                    children: const [
                                      TextSpan(
                                        text: 'Digite sua nova senha!',
                                      ),
                                    ],
                                  ),
                                ),
                                SizedBox(
                                  height: 16.h,
                                ),
                                passwordTextField(size),
                                SizedBox(
                                  height: 8.h,
                                ),
                                passwordConfirmationTextField(size),
                                SizedBox(
                                  height: 8.h,
                                ),
                              ],
                            ),
                          ),
                        ),
                      ),
                      SizedBox(
                        height: 16.h,
                      ),
                      Expanded(
                        flex: 1,
                        child: Column(
                          children: [
                            signInButton(size),
                            const Spacer(),
                          ],
                        ),
                      )
                    ],
                  ),
                )
              ],
            )),
      ),
    );
  }

  Widget welcomeText() {
    return Center(
      child: Text.rich(
        TextSpan(
          style: GoogleFonts.inter(
            fontSize: 26.0.sp,
            color: const Color(0xFF010101),
            height: 1.45.h,
          ),
          children: const [
            TextSpan(
              text: 'Recuperação de senha!',
            ),
          ],
        ),
      ),
    );
  }

  Widget reportCityLogo(double height_, double width_) {
    return Image.asset(
      'assets/reportCityLogo.png',
      width: width_,
      height: height_,
    );
  }

  Widget passwordTextField(Size size) {
    return TextFormField(
      controller: _passwordController,
      maxLines: 1,
      cursorColor: const Color(0xFF3A6642),
      obscureText: true,
      keyboardType: TextInputType.visiblePassword,
      validator: (value) {
        if (value!.isEmpty) {
          return "Insira sua senha!";
        }

        return null;
      },
      style: GoogleFonts.inter(
        fontSize: 17.sp,
        color: const Color(0xFF37623A),
        fontWeight: FontWeight.w500,
      ),
      decoration: InputDecoration(
        labelText: "Senha",
        labelStyle: GoogleFonts.inter(
          fontSize: 12.sp,
          color: const Color(0xFF8b8a84),
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

  Widget passwordConfirmationTextField(Size size) {
    return TextFormField(
      controller: _passwordConfirmationController,
      maxLines: 1,
      cursorColor: const Color(0xFF3A6642),
      obscureText: true,
      keyboardType: TextInputType.visiblePassword,
      validator: (value) {
        if (value!.isEmpty) {
          return "Insira sua senha!";
        }

        if (_passwordController.text != _passwordConfirmationController.text) {
          return "As senhas devem ser idênticas!";
        }

        return null;
      },
      style: GoogleFonts.inter(
        fontSize: 17.sp,
        color: const Color(0xFF37623A),
        fontWeight: FontWeight.w500,
      ),
      decoration: InputDecoration(
        labelText: "Confirmação de senha",
        labelStyle: GoogleFonts.inter(
          fontSize: 12.sp,
          color: const Color(0xFF8b8a84),
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

  Widget signInButton(Size size) {
    return ElevatedButton(
      onPressed: () {
        Navigator.pop(context);
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
        "Trocar senha",
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
