import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_svg/svg.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:email_validator/email_validator.dart';

class Login extends StatefulWidget {
  const Login({super.key});

  @override
  State<Login> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();
  final _loginFormKey = GlobalKey<FormState>();

  bool _rememberLogin = false;

  @override
  void dispose() {
    // Clean up the controller when the widget is disposed.
    _emailController.dispose();
    _passwordController.dispose();

    super.dispose();
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
                        flex: 3,
                        child: Column(
                          children: <Widget>[
                            reportCityLogo(size.height / 5, size.height / 5),
                          ],
                        ),
                      ),
                      Expanded(
                        flex: 3,
                        child: Form(
                          key: _loginFormKey,
                          autovalidateMode: AutovalidateMode.always,
                          child: Column(
                            children: [
                              emailTextField(size),
                              SizedBox(
                                height: 8.h,
                              ),
                              passwordTextField(size),
                              SizedBox(
                                height: 8.h,
                              ),
                              forgotPasswordText(),
                            ],
                          ),
                        ),
                      ),
                      Expanded(
                        flex: 3,
                        child: Column(
                          children: [
                            const Spacer(),
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
            fontSize: 22.0.sp,
            color: const Color(0xFF010101),
            height: 1.45.h,
          ),
          children: const [
            TextSpan(
              text: 'Seja bem-vindo',
            ),
            TextSpan(
              text: ', ',
            ),
            TextSpan(
              text: 'realize o',
            ),
            TextSpan(
              text: " ",
            ),
            TextSpan(
              text: 'Login',
              style: TextStyle(
                fontWeight: FontWeight.w600,
                decoration: TextDecoration.underline,
              ),
            ),
            TextSpan(
              text: " ",
              style: TextStyle(
                fontWeight: FontWeight.w600,
              ),
            ),
            TextSpan(
              text: "para continuar!",
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

  Widget emailTextField(Size size) {
    return SizedBox(
      child: TextFormField(
        controller: _emailController,
        maxLines: 1,
        keyboardType: TextInputType.emailAddress,
        cursorColor: const Color(0xFF3A6642),
        validator: (value) {
          if (value!.isEmpty) {
            return "Insira seu e-mail!";
          }

          if (!EmailValidator.validate(value)) {
            return "E-mail incorreto!";
          }
          return null;
        },
        style: GoogleFonts.inter(
          fontSize: 17.sp,
          color: const Color(0xFF37623A),
          fontWeight: FontWeight.w500,
        ),
        decoration: InputDecoration(
          labelText: "E-mail",
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
      ),
    );
  }

  Widget passwordTextField(Size size) {
    return SizedBox(
      child: TextFormField(
        controller: _passwordController,
        maxLines: 1,
        obscureText: true,
        cursorColor: const Color(0xFF3A6642),
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
      ),
    );
  }

  Widget forgotPasswordText() {
    return Row(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Expanded(
          child: CheckboxListTile.adaptive(
            value: _rememberLogin,
            onChanged: (bool? value) {
              setState(() {
                _rememberLogin = value!;
              });
            },
            checkColor: const Color(0xFFf6f6f6),
            activeColor: const Color(0xFF3a6642),
            title: Text(
              "Lembrar meu login",
              style: GoogleFonts.inter(
                fontSize: 12.sp,
                color: const Color(0xFF494845),
              ),
            ),
            visualDensity: VisualDensity.compact,
            controlAffinity: ListTileControlAffinity.leading,
          ),
        ),
        TextButton(
          style: ButtonStyle(
            fixedSize: WidgetStatePropertyAll(
              Size(
                175.w,
                25.h,
              ),
            ),
          ),
          onPressed: () {
            Navigator.pushNamed(context, "/recoverySMS");
          },
          child: Text(
            "Esqueceu sua senha?",
            style: GoogleFonts.inter(
              fontSize: 12.sp,
              color: const Color(0xFF494845),
            ),
            textAlign: TextAlign.right,
          ),
        ),
      ],
    );
  }

  Widget signInButton(Size size) {
    return ElevatedButton(
      onPressed: () {
        Navigator.popAndPushNamed(context, "/home");
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
        "Logar",
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

  Widget noAccountText() {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: <Widget>[
        const Expanded(
          flex: 2,
          child: Divider(
            color: Color(0xFF9e9d99),
          ),
        ),
        Expanded(
          flex: 3,
          child: Text(
            "Não possui uma conta?",
            textAlign: TextAlign.center,
            style: GoogleFonts.inter(
              fontSize: 12.sp,
              color: const Color(0xFF9e9d99),
              fontWeight: FontWeight.w500,
              height: 1.67.sp,
            ),
          ),
        ),
        const Expanded(
          flex: 2,
          child: Divider(
            color: Color(0xFF9e9d99),
          ),
        ),
      ],
    );
  }

  Widget createAccountButton(Size size) {
    return OutlinedButton(
      onPressed: () {
        Navigator.pushNamed(context, "/signin");
      },
      style: ButtonStyle(
        alignment: Alignment.center,
        fixedSize: WidgetStatePropertyAll(
          Size(size.width, 50.h),
        ),
        overlayColor: WidgetStatePropertyAll(
          const Color(0xFFa6cfad).withOpacity(0.2),
        ),
      ),
      child: Text(
        'Criar um conta',
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

// child: Column(
  //           children: <Widget>[
  //             Expanded(
  //               flex: 2,
  //               child: Align(
  //                 alignment: Alignment.centerLeft,
  //                 child: SizedBox(
  //                   width: size.width * 0.65,
  //                   child: welcomeText(),
  //                 ),
  //               ),
  //             ),
  //             Expanded(
  //               flex: 3,
  //               child: Column(
  //                 children: <Widget>[
  //                   reportCityLogo(size.height / 5, size.height / 5),
  //                 ],
  //               ),
  //             ),
  //             Expanded(
  //               flex: 4,
  //               child: Form(
  //                 key: _loginFormKey,
  //                 child: Column(
  //                   children: [
  //                     emailTextField(size),
  //                     SizedBox(
  //                       height: 8.h,
  //                     ),
  //                     passwordTextField(size),
  //                     forgotPasswordText(),
  //                   ],
  //                 ),
  //               ),
  //             ),
  //             Expanded(
  //               flex: 3,
  //               child: Column(
  //                 children: [
  //                   signInButton(size),
  //                   const Spacer(),
  //                   noAccountText(),
  //                   const Spacer(),
  //                   createAccountButton(size),
  //                   const Spacer(),
  //                 ],
  //               ),
  //             )
  //           ],
  //         ),

/** 
 SafeArea(
        child: Padding(
          padding: EdgeInsets.symmetric(horizontal: 8.w, vertical: 16.h),
          child: SingleChildScrollView(
            child: Flex(
              direction: Axis.vertical,
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Container(
                  height: 300.h,
                  width: 300.w,
                  decoration: BoxDecoration(
                    border: Border.all(
                      width: 1.w,
                    ),
                    borderRadius: BorderRadius.circular(360.r),
                    color: Colors.black26,
                  ),
                ),
                SizedBox(
                  height: 16.h,
                ),
                ConstrainedBox(
                  constraints: BoxConstraints(
                    minHeight: 295.h,
                    minWidth: 400.w,
                    maxHeight: 338.6.h,
                    maxWidth: 400.w,
                  ),
                  child: Container(
                    decoration: BoxDecoration(
                      color: const Color(0xff82bd69),
                      borderRadius: BorderRadius.circular(
                        16.r,
                      ),
                    ),
                    child: Form(
                      autovalidateMode: AutovalidateMode.always,
                      key: _loginFormKey,
                      child: Flex(
                        direction: Axis.vertical,
                        children: [
                          Padding(
                            padding: EdgeInsets.fromLTRB(16.w, 16.h, 16.w, 4.h),
                            child: TextFormField(
                              keyboardType: TextInputType.emailAddress,
                              autocorrect: false,
                              style: const TextStyle(),
                              controller: _loginEmailController,
                              decoration: InputDecoration(
                                contentPadding: EdgeInsets.symmetric(
                                  vertical: 15.h,
                                  horizontal: 10.w,
                                ),
                                enabledBorder: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                errorBorder: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.red,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                focusedBorder: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                disabledBorder: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                border: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                labelText: "E-mail",
                              ),
                              onSaved: (String? value) {},
                              validator: (String? value) {
                                return value != null && !value.contains("@")
                                    ? "E-mail incorreto"
                                    : null;
                              },
                            ),
                          ),
                          Padding(
                            padding: EdgeInsets.fromLTRB(16.w, 4.h, 16.w, 4.h),
                            child: TextFormField(
                              obscureText: true,
                              autocorrect: false,
                              style: const TextStyle(),
                              controller: _loginPasswordController,
                              decoration: InputDecoration(
                                contentPadding: EdgeInsets.symmetric(
                                  vertical: 15.h,
                                  horizontal: 10.w,
                                ),
                                enabledBorder: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                focusedBorder: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                disabledBorder: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                border: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                labelText: 'Senha',
                              ),
                            ),
                          ),
                          Padding(
                            padding: EdgeInsets.fromLTRB(16.w, 4.h, 16.w, 8.h),
                            child: ElevatedButton(
                              onPressed: () {},
                              child: const Text("Logar-se"),
                            ),
                          ),
                          Padding(
                            padding: EdgeInsets.fromLTRB(16.w, 8.h, 16.w, 8.h),
                            child: ElevatedButton(
                              onPressed: () {},
                              child: const Text("Esqueci minha senha."),
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
        ),
      ),
*/

/*

Center(
              child: Flex(
                direction: Axis.vertical,
                children: [
                  Container(
                    height: 300.h,
                    width: 300.w,
                    decoration: BoxDecoration(
                      border: Border.all(
                        width: 1.w,
                      ),
                      borderRadius: BorderRadius.circular(360.r),
                      color: Colors.black26,
                    ),
                  ),
                  Container(
                    height: 287.h,
                    width: 400.w,
                    decoration: BoxDecoration(
                      color: const Color(0xff82bd69),
                      borderRadius: BorderRadius.circular(
                        16.r,
                      ),
                    ),
                    child: Form(
                      autovalidateMode: AutovalidateMode.always,
                      key: _loginFormKey,
                      child: Flex(
                        direction: Axis.vertical,
                        children: [
                          Padding(
                            padding: EdgeInsets.fromLTRB(16.w, 16.h, 16.w, 8.h),
                            child: TextFormField(
                              keyboardType: TextInputType.emailAddress,
                              autocorrect: false,
                              style: const TextStyle(),
                              controller: _loginEmailController,
                              decoration: InputDecoration(
                                contentPadding: EdgeInsets.symmetric(
                                  vertical: 15.h,
                                  horizontal: 10.w,
                                ),
                                enabledBorder: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                errorBorder: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.red,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                focusedBorder: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                disabledBorder: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                border: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                labelText: "E-mail",
                              ),
                              onSaved: (String? value) {},
                              validator: (String? value) {
                                return value != null && !value.contains("@")
                                    ? "E-mail incorreto"
                                    : null;
                              },
                            ),
                          ),
                          Padding(
                            padding: EdgeInsets.fromLTRB(16.w, 16.h, 16.w, 8.h),
                            child: TextFormField(
                              obscureText: true,
                              autocorrect: false,
                              style: const TextStyle(),
                              controller: _loginPasswordController,
                              decoration: InputDecoration(
                                contentPadding: EdgeInsets.symmetric(
                                  vertical: 15.h,
                                  horizontal: 10.w,
                                ),
                                enabledBorder: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                focusedBorder: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                disabledBorder: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                border: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    style: BorderStyle.solid,
                                    strokeAlign: BorderSide.strokeAlignCenter,
                                    width: 1.5.w,
                                    color: Colors.black,
                                  ),
                                  borderRadius: BorderRadius.circular(
                                    8.r,
                                  ),
                                ),
                                labelText: 'Senha',
                              ),
                            ),
                          ),
                          Padding(
                            padding: EdgeInsets.fromLTRB(16.w, 16.h, 16.w, 8.h),
                            child: ElevatedButton(
                              onPressed: () {},
                              child: const Text("Logar-se"),
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),
                ],
              ),
            ),

*/
