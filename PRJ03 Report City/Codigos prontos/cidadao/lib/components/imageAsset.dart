import 'package:flutter/material.dart';

class ImageAsset extends StatelessWidget {
  const ImageAsset({
    super.key,
    required this.asset,
    required this.width_,
    required this.height_,
    required this.imageAlignment,
    required this.hasAntiAlias,
    required this.imageFilterQuality,
  });

  final String asset;
  final double width_;
  final double height_;
  final Alignment imageAlignment;
  final bool hasAntiAlias;
  final FilterQuality imageFilterQuality;

  @override
  Widget build(BuildContext context) {
    return Image.asset(
      asset,
      width: width_,
      height: height_,
      filterQuality: imageFilterQuality,
      isAntiAlias: true,
      alignment: imageAlignment,
    );
  }
}
