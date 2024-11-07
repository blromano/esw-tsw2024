import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class HomeReport extends StatefulWidget {
  const HomeReport({super.key});

  @override
  State<HomeReport> createState() => _HomeReportState();
}

class _HomeReportState extends State<HomeReport> {
  int reportsAmount = 1;

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Padding(
        padding: EdgeInsets.symmetric(
          horizontal: 8.w,
          vertical: 16.h,
        ),
        child: RefreshIndicator(
          onRefresh: () => Future.delayed(
            const Duration(seconds: 1),
          ),
          child: SingleChildScrollView(
            physics: const AlwaysScrollableScrollPhysics(),
            child: IntrinsicHeight(
              child: reportsAmount == 0
                  ? const Align(
                      alignment: Alignment.center,
                      child: Text("Nenhuma denúncia foi realizada"),
                    )
                  : const Column(
                      // children: [
                      //   for (int x = 1; x <= 4; x++) ...[
                      //     Container(
                      //       height: 100,
                      //       color: Colors.redAccent,
                      //     )
                      //   ]
                      // ],
                      ),
            ),
          ),
        ),
      ),
    );
  }
}
