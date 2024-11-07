import 'package:cidadao/components/elevatedButton.dart';
import 'package:cidadao/components/imageAsset.dart';
import 'package:cidadao/components/outlinedButton.dart';
import 'package:cidadao/components/textFormField.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:email_validator/email_validator.dart';
import 'package:get/get.dart' hide Response, FormData, MultipartFile;
import 'package:dio/dio.dart';
import 'package:brasil_fields/brasil_fields.dart';
import 'package:google_fonts/google_fonts.dart';

class UpdateProfile extends StatefulWidget {
  const UpdateProfile({super.key});

  @override
  State<UpdateProfile> createState() => _UpdateProfileState();
}

class _UpdateProfileState extends State<UpdateProfile> {
  final _updateProfileState = GlobalKey<FormState>();

  final TextEditingController _fullNameController = TextEditingController();
  final TextEditingController _cpfController = TextEditingController();
  final TextEditingController _phoneController = TextEditingController();
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _zipController = TextEditingController();
  final TextEditingController _streetController = TextEditingController();
  final TextEditingController _houseNumberController = TextEditingController();
  final TextEditingController _complementController = TextEditingController();
  final TextEditingController _neighborhoodController = TextEditingController();
  final TextEditingController _cityController = TextEditingController();
  final TextEditingController _stateController = TextEditingController();

  @override
  void dispose() {
    // Clean up the controller when the widget is disposed.
    _fullNameController.dispose();
    _cpfController.dispose();
    _phoneController.dispose();
    _emailController.dispose();
    _zipController.dispose();
    _streetController.dispose();
    _houseNumberController.dispose();
    _complementController.dispose();
    _neighborhoodController.dispose();
    _cityController.dispose();
    _stateController.dispose();
    super.dispose();
  }

  Future<void> getZipCodeInfo(String normalizedZipCode) async {
    try {
      Response<dynamic> response = await Dio().get(
        "https://viacep.com.br/ws/$normalizedZipCode/json/",
        options: Options(
          responseType: ResponseType.json,
        ),
      );

      if (response.data['logradouro'] == null) {
        throw DioException.badResponse(
          statusCode: response.statusCode!.toInt(),
          requestOptions: response.requestOptions,
          response: response,
        );
      } else {
        _streetController.text = response.data['logradouro'];
        _neighborhoodController.text = response.data['bairro'];
        _cityController.text = response.data['localidade'];
        _stateController.text = response.data['uf'];
        _updateProfileState.currentState!.validate();
      }
    } on DioException catch (e) {
      if (e.response != null) {
        print(e.response?.data);
        print(e.response?.headers);
        print(e.response?.requestOptions);
      } else {
        // Something happened in setting up or sending the request that triggered an Error
        print(e.requestOptions);
        print(e.message);
      }
    }
  }

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
                    flex: 2,
                    child: Align(
                      alignment: Alignment.centerLeft,
                      child: SizedBox(
                        width: 250.w,
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
                                  text: 'Atualizar o',
                                ),
                                TextSpan(
                                  text: ' ',
                                ),
                                TextSpan(
                                  text: 'Cadastro!',
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
                    flex: 11,
                    child: Form(
                      key: _updateProfileState,
                      child: Flex(
                        direction: Axis.vertical,
                        children: [
                          TextFormFieldWidget(
                            isEnabled: true,

                            textFormFieldController: _fullNameController,
                            formKey: _updateProfileState,
                            callback: (value) {
                              if (value!.isEmpty) {
                                return "Insira seu nome completo!";
                              }
                            },
                            label: "Nome completo",
                            maxLines: 1,
                            textInputType: TextInputType.name,
                            isObscure: false,
                            //scrollPaddingHeight: MediaQuery.of(context).viewInsets.bottom + 20,
                            textInputAction: TextInputAction.next,
                            textInputFormatter: [
                              LengthLimitingTextInputFormatter(128)
                            ],
                            //maxLength: 128,
                            maxLengthEnforced: MaxLengthEnforcement.enforced,
                          ),
                          SizedBox(
                            height: 8.h,
                          ),
                          TextFormFieldWidget(
                            isEnabled: false,
                            textFormFieldController: _cpfController,
                            formKey: _updateProfileState,
                            callback: (value) {
                              if (value!.isEmpty) {
                                return "Insira seu CPF!";
                              }

                              if (!GetUtils.isCpf(value)) {
                                return "CPF incorreto";
                              }

                              return null;
                            },
                            label: "CPF",
                            maxLines: 1,
                            textInputType: TextInputType.number,
                            isObscure: false,
                            //scrollPaddingHeight: MediaQuery.of(context).viewInsets.bottom + 20,
                            textInputAction: TextInputAction.next,
                            textInputFormatter: [
                              FilteringTextInputFormatter.digitsOnly,
                              CpfInputFormatter(),
                              LengthLimitingTextInputFormatter(14)
                            ],
                            //maxLength: 14,
                            maxLengthEnforced: MaxLengthEnforcement.enforced,
                          ),
                          SizedBox(
                            height: 8.h,
                          ),
                          TextFormFieldWidget(
                            isEnabled: true,

                            textFormFieldController: _phoneController,
                            formKey: _updateProfileState,
                            callback: (value) {
                              if (value.isEmpty) {
                                return "Insira seu celular";
                              }

                              return null;
                            },
                            label: "Celular",
                            maxLines: 1,
                            textInputType: TextInputType.number,
                            isObscure: false,
                            textInputAction: TextInputAction.next,
                            textInputFormatter: [
                              FilteringTextInputFormatter.digitsOnly,
                              TelefoneInputFormatter(),
                              LengthLimitingTextInputFormatter(15)
                            ],
                            //maxLength: 11,
                            maxLengthEnforced: MaxLengthEnforcement.enforced,
                          ),
                          SizedBox(
                            height: 8.h,
                          ),
                          TextFormFieldWidget(
                            isEnabled: true,

                            textFormFieldController: _emailController,
                            isObscure: false,
                            //scrollPaddingHeight: MediaQuery.of(context).viewInsets.bottom + 20,
                            textInputAction: TextInputAction.next,
                            formKey: _updateProfileState,
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
                            // maxLength: 255,
                            maxLengthEnforced: MaxLengthEnforcement.enforced,
                          ),
                          SizedBox(
                            height: 8.h,
                          ),
                          Row(
                            mainAxisAlignment: MainAxisAlignment.center,
                            crossAxisAlignment: CrossAxisAlignment.center,
                            children: <Widget>[
                              const Expanded(
                                flex: 3,
                                child: Divider(
                                  color: Color(0xFF9e9d99),
                                ),
                              ),
                              Expanded(
                                flex: 2,
                                child: Text(
                                  "Endereço",
                                  textAlign: TextAlign.center,
                                  style: GoogleFonts.inter(
                                    fontSize: 12.sp,
                                    color:
                                        const Color.fromARGB(255, 77, 71, 50),
                                    fontWeight: FontWeight.w500,
                                    height: 1.67.sp,
                                  ),
                                ),
                              ),
                              const Expanded(
                                flex: 3,
                                child: Divider(
                                  color: Color(0xFF9e9d99),
                                ),
                              ),
                            ],
                          ),
                          SizedBox(
                            height: 8.h,
                          ),
                          TextFormFieldWidget(
                            isEnabled: true,
                            textFormFieldController: _zipController,
                            formKey: _updateProfileState,
                            callback: (value) {
                              if (value!.isEmpty) {
                                return "Insira seu CEP!";
                              }
                              return null;
                            },
                            label: "CEP",
                            maxLines: 1,
                            textInputType: TextInputType.number,
                            isObscure: false,
                            textInputAction: TextInputAction.next,
                            textInputFormatter: [
                              FilteringTextInputFormatter.digitsOnly,
                              CepInputFormatter(),
                              LengthLimitingTextInputFormatter(10)
                            ],
                            onEditComplete: () {
                              if (_zipController.text.isNotEmpty) {
                                final String normalizedZipCode =
                                    UtilBrasilFields.removeCaracteres(
                                        _zipController.text);

                                getZipCodeInfo(normalizedZipCode);
                                FocusScope.of(context).nextFocus();
                              } else {}
                            },
                            //maxLength: 8,
                            maxLengthEnforced: MaxLengthEnforcement.enforced,
                          ),
                          SizedBox(
                            height: 8.h,
                          ),
                          Row(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            children: [
                              SizedBox(
                                width: screenSize.width * 0.65,
                                child: TextFormFieldWidget(
                                  isEnabled: true,

                                  textFormFieldController: _streetController,
                                  formKey: _updateProfileState,
                                  callback: (value) {
                                    if (value!.isEmpty) {
                                      return "Insira a rua!";
                                    }
                                    return null;
                                  },
                                  label: "Rua",
                                  maxLines: 1,
                                  textInputType: TextInputType.streetAddress,
                                  isObscure: false,
                                  textInputAction: TextInputAction.next,
                                  textInputFormatter: [
                                    LengthLimitingTextInputFormatter(255)
                                  ],
                                  //maxLength: 255,
                                  maxLengthEnforced:
                                      MaxLengthEnforcement.enforced,
                                ),
                              ),
                              SizedBox(
                                width: screenSize.width * 0.3,
                                child: TextFormFieldWidget(
                                  isEnabled: true,

                                  textFormFieldController:
                                      _houseNumberController,
                                  formKey: _updateProfileState,
                                  callback: (value) {
                                    if (value!.isEmpty) {
                                      return "Insira o número!";
                                    }
                                    return null;
                                  },
                                  label: "Numero",
                                  maxLines: 1,
                                  textInputType: TextInputType.streetAddress,
                                  isObscure: false,
                                  textInputAction: TextInputAction.next,
                                  textInputFormatter: [
                                    LengthLimitingTextInputFormatter(6)
                                  ],
                                  //maxLength: 6,
                                  maxLengthEnforced:
                                      MaxLengthEnforcement.enforced,
                                ),
                              )
                            ],
                          ),
                          SizedBox(
                            height: 8.h,
                          ),
                          TextFormFieldWidget(
                            isEnabled: true,
                            textFormFieldController: _complementController,
                            formKey: _updateProfileState,
                            callback: (value) {
                              return null;
                            },
                            label: "Complemento",
                            maxLines: 1,
                            textInputType: TextInputType.streetAddress,
                            isObscure: false,
                            textInputAction: TextInputAction.next,
                            maxLength: 16,
                            maxLengthEnforced: MaxLengthEnforcement.enforced,
                          ),
                          SizedBox(
                            height: 8.h,
                          ),
                          TextFormFieldWidget(
                            isEnabled: true,

                            textFormFieldController: _neighborhoodController,
                            formKey: _updateProfileState,
                            callback: (value) {
                              if (value.isEmpty) {
                                return "Insira o bairro!";
                              }
                              return null;
                            },
                            label: "Bairro",
                            maxLines: 1,
                            textInputType: TextInputType.streetAddress,
                            isObscure: false,
                            textInputAction: TextInputAction.next,
                            textInputFormatter: [
                              LengthLimitingTextInputFormatter(64)
                            ],
                            //maxLength: 64,
                            maxLengthEnforced: MaxLengthEnforcement.enforced,
                          ),
                          SizedBox(
                            height: 8.h,
                          ),
                          TextFormFieldWidget(
                            isEnabled: true,

                            textFormFieldController: _cityController,
                            formKey: _updateProfileState,
                            callback: (value) {
                              if (value.isEmpty) {
                                return "Insira a cidade!";
                              }
                              return null;
                            },
                            label: "Cidade",
                            maxLines: 1,
                            textInputType: TextInputType.streetAddress,
                            isObscure: false,
                            textInputAction: TextInputAction.next,
                            textInputFormatter: [
                              LengthLimitingTextInputFormatter(32)
                            ],
                            //maxLength: 32,
                            maxLengthEnforced: MaxLengthEnforcement.enforced,
                          ),
                          SizedBox(
                            height: 8.h,
                          ),
                          TextFormFieldWidget(
                            isEnabled: true,

                            textFormFieldController: _stateController,
                            formKey: _updateProfileState,
                            callback: (value) {
                              if (value.isEmpty) {
                                return "Insira o estado!";
                              }
                              return null;
                            },
                            label: "Estado",
                            maxLines: 1,
                            textInputType: TextInputType.streetAddress,
                            isObscure: false,
                            textInputAction: TextInputAction.next,
                            textInputFormatter: [
                              LengthLimitingTextInputFormatter(32)
                            ],
                            //maxLength: 32,
                            maxLengthEnforced: MaxLengthEnforcement.enforced,
                          ),
                        ],
                      ),
                    ),
                  ),
                  SizedBox(
                    height: 16.h,
                  ),
                  ElevatedButtonWidget(
                    callback: () {
                      if (_updateProfileState.currentState!.validate()) {
                        Navigator.popAndPushNamed(context, "/home");
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
                    label: "Atualizar",
                  ),
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
