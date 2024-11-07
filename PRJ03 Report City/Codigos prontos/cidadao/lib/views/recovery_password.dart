import 'package:cidadao/components/elevatedButton.dart';
import 'package:cidadao/components/imageAsset.dart';
import 'package:cidadao/components/textFormField.dart';
import 'package:email_validator/email_validator.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:google_fonts/google_fonts.dart';

class RecoveryPassword extends StatefulWidget {
  final String? email;

  const RecoveryPassword({
    super.key,
    this.email,
  });

  @override
  State<RecoveryPassword> createState() => _RecoveryPasswordState();
}

class _RecoveryPasswordState extends State<RecoveryPassword> {
  final TextEditingController _emailController = TextEditingController();
  final _passwordRecoveryFormKey = GlobalKey<FormState>();

  @override
  void dispose() {
    // Clean up the controller when the widget is disposed.
    _emailController.dispose();

    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final screenSize = MediaQuery.of(context).size;

    if (widget.email!.isNotEmpty) {
      _emailController.text = widget.email!;
    }

    return Scaffold(
      resizeToAvoidBottomInset: false,
      backgroundColor: const Color(0xFFDCDCDA),
      body: SafeArea(
        child: Padding(
          padding: EdgeInsets.symmetric(
            vertical: 8.h,
            horizontal: 8.w,
          ),
          child: SingleChildScrollView(
            child: IntrinsicHeight(
              child: Column(
                children: <Widget>[
                  Expanded(
                    flex: 3,
                    child: Align(
                      alignment: Alignment.centerLeft,
                      child: SizedBox(
                        width: 200.w,
                        child: Center(
                          child: Text.rich(
                            TextSpan(
                              style: GoogleFonts.inter(
                                fontSize: 22.0.sp,
                                color: const Color(0xFF262624),
                                height: 1.45.h,
                              ),
                              children: const [
                                TextSpan(
                                  text: 'Recuperação de',
                                ),
                                TextSpan(
                                  text: ' ',
                                ),
                                // TextSpan(
                                //   text: 'realize o',
                                // ),
                                // TextSpan(
                                //   text: " ",
                                // ),
                                TextSpan(
                                  text: 'senha!',
                                  style: TextStyle(
                                    fontWeight: FontWeight.w600,
                                    decoration: TextDecoration.underline,
                                  ),
                                ),
                                // TextSpan(
                                //   text: " ",
                                //   style: TextStyle(
                                //     fontWeight: FontWeight.w600,
                                //   ),
                                // ),
                                // TextSpan(
                                //   text: "para continuar!",
                                // ),
                              ],
                            ),
                          ),
                        ),
                      ),
                    ),
                  ),
                  Expanded(
                    flex: 6,
                    child: ImageAsset(
                      asset: 'assets/reportCityLogo.png',
                      width_: screenSize.height / 5,
                      height_: screenSize.height / 5,
                      imageAlignment: Alignment.center,
                      hasAntiAlias: true,
                      imageFilterQuality: FilterQuality.high,
                    ),
                  ),
                  Expanded(
                    flex: 4,
                    child: Form(
                      key: _passwordRecoveryFormKey,
                      child: Flex(
                        direction: Axis.vertical,
                        children: [
                          Align(
                            alignment: Alignment.centerLeft,
                            child: Text(
                              "Por favor, insira seu e-mail para recuperar a sua senha.",
                              style: TextStyle(
                                fontSize: 14.sp,
                              ),
                            ),
                          ),
                          SizedBox(
                            height: 8.h,
                          ),
                          TextFormFieldWidget(
                            isEnabled: true,

                            textFormFieldController: _emailController,
                            isObscure: false,
                            //scrollPaddingHeight: MediaQuery.of(context).viewInsets.bottom + 20,
                            textInputAction: TextInputAction.done,
                            formKey: _passwordRecoveryFormKey,
                            callback: (value) {
                              if (value!.isEmpty) {
                                return "Insira seu e-mail!";
                              }

                              if (!EmailValidator.validate(value)) {
                                return "E-mail incorreto!";
                              }
                              return null;
                            },
                            label: "E-mail",
                            maxLines: 1,
                            textInputType: TextInputType.emailAddress,
                            textInputFormatter: [
                              LengthLimitingTextInputFormatter(255)
                            ],
                            maxLengthEnforced: MaxLengthEnforcement.enforced,
                          ),
                          SizedBox(
                            height: 8.h,
                          ),
                        ],
                      ),
                    ),
                  ),
                  Expanded(
                    flex: 1,
                    child: Flex(
                      direction: Axis.vertical,
                      children: [
                        ElevatedButtonWidget(
                          callback: () {
                            if (_passwordRecoveryFormKey.currentState!
                                .validate()) {
                              Navigator.popAndPushNamed(
                                context,
                                "/mfa_recovery_password",
                                arguments: _emailController.text,
                              );
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
                          label: "Prosseguir com a recuperação",
                        ),
                      ],
                    ),
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
