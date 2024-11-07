import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class HomeNotifications extends StatefulWidget {
  const HomeNotifications({super.key});

  @override
  State<HomeNotifications> createState() => _HomeNotificationsState();
}

class _HomeNotificationsState extends State<HomeNotifications> {
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
          child: const SingleChildScrollView(
            child: IntrinsicHeight(
              child: Column(
                children: [],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
