import 'package:cidadao/components/password_validator.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_pw_validator/flutter_pw_validator.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:cidadao/components/elevatedButton.dart';
import 'package:cidadao/components/imageAsset.dart';
import 'package:cidadao/components/textFormField.dart';

class NewPassword extends StatefulWidget {
  const NewPassword({super.key});

  @override
  State<NewPassword> createState() => _NewPasswordState();
}

class _NewPasswordState extends State<NewPassword> {
  final TextEditingController _passwordController = TextEditingController();
  final TextEditingController _passwordConfirmationController =
      TextEditingController();

  final _newPasswordFormKey = GlobalKey<FormState>();
  final GlobalKey<FlutterPwValidatorState> _passwordValidatorKey =
      GlobalKey<FlutterPwValidatorState>();

  @override
  Widget build(BuildContext context) {
    final screenSize = MediaQuery.of(context).size;

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
                                  text: 'Insira',
                                ),
                                TextSpan(
                                  text: ' ',
                                ),
                                TextSpan(
                                  text: 'sua nova',
                                ),
                                TextSpan(
                                  text: ' ',
                                ),
                                TextSpan(
                                  text: 'senha!',
                                  style: TextStyle(
                                    fontWeight: FontWeight.w600,
                                    decoration: TextDecoration.underline,
                                  ),
                                ),
                              ],
                            ),
                          ),
                        ),
                      ),
                    ),
                  ),
                  Expanded(
                    flex: 4,
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
                    flex: 5,
                    child: Form(
                      key: _newPasswordFormKey,
                      child: Flex(
                        direction: Axis.vertical,
                        children: [
                          TextFormFieldWidget(
                            isEnabled: true,

                            textFormFieldController: _passwordController,
                            isObscure: true,
                            //scrollPaddingHeight: MediaQuery.of(context).viewInsets.bottom + 20,
                            textInputAction: TextInputAction.next,
                            formKey: _newPasswordFormKey,
                            callback: (value) {
                              if (value!.isEmpty) {
                                return "Insira sua senha!";
                              }

                              return null;
                            },
                            label: "Senha",
                            maxLines: 1,
                            textInputType: TextInputType.visiblePassword,
                            textInputFormatter: [
                              LengthLimitingTextInputFormatter(60)
                            ],
                            //maxLength: 60,
                            maxLengthEnforced: MaxLengthEnforcement.enforced,
                          ),
                          SizedBox(
                            height: 8.h,
                          ),
                          PasswordValidator(
                            validatorStateKey: _passwordValidatorKey,
                            width: screenSize.width,
                            height: 150.h,
                            onSuccessCallback: () {},
                            onFailureCallback: (value) {},
                            passwordController: _passwordController,
                            minLength: 8,
                          ),
                          SizedBox(
                            height: 8.h,
                          ),
                          TextFormFieldWidget(
                            isEnabled: true,

                            textFormFieldController:
                                _passwordConfirmationController,
                            isObscure: true,
                            //scrollPaddingHeight: MediaQuery.of(context).viewInsets.bottom + 20,
                            textInputAction: TextInputAction.done,
                            formKey: _newPasswordFormKey,
                            callback: (value) {
                              if (value!.isEmpty) {
                                return "Insira a confirmação da sua senha!";
                              }

                              if (_passwordController.text !=
                                  _passwordConfirmationController.text) {
                                return "As senhas devem ser idênticas";
                              }

                              return null;
                            },
                            label: "Confirmação de senha",
                            maxLines: 1,
                            textInputType: TextInputType.visiblePassword,
                            textInputFormatter: [
                              LengthLimitingTextInputFormatter(60)
                            ],
                            // maxLength: 60,
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
                            if (_newPasswordFormKey.currentState!.validate()) {
                              Navigator.popAndPushNamed(context, "/");
                            } else {
                              ScaffoldMessenger.of(context).showSnackBar(
                                const SnackBar(
                                  content: Text(
                                    'Insira sua senha!',
                                  ),
                                ),
                              );
                            }
                          },
                          width_: screenSize.width,
                          height_: 50.h,
                          label: "Recuperar senha",
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
