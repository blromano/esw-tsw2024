import 'package:cidadao/views/home_notifications.dart';
import 'package:cidadao/views/home_profile.dart';
import 'package:cidadao/views/home_report.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class Home extends StatefulWidget {
  const Home({super.key});

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  int currentPageIndex = 1;

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      resizeToAvoidBottomInset: false,
      backgroundColor: const Color(0xFFDCDCDA),
      bottomNavigationBar: NavigationBar(
        backgroundColor: const Color(0xFFf6f6f6),
        onDestinationSelected: (int index) {
          setState(
            () {
              currentPageIndex = index;
            },
          );
        },
        selectedIndex: currentPageIndex,
        indicatorColor: const Color(0xFFcee4d2),
        destinations: const <Widget>[
          NavigationDestination(
            selectedIcon:
                Icon(Icons.notifications_sharp, color: Color(0xFF2e4d34)),
            icon: Icon(Icons.notifications_outlined),
            label: 'Notificações',
          ),
          NavigationDestination(
            selectedIcon: Icon(Icons.home, color: Color(0xFF2e4d34)),
            icon: Icon(Icons.home_outlined),
            label: 'Feed',
          ),
          NavigationDestination(
            selectedIcon: Icon(Icons.person, color: Color(0xFF2e4d34)),
            icon: Icon(Icons.person_outline),
            label: 'Perfil',
          ),
        ],
      ),
      body: const <Widget>[
        HomeNotifications(),
        HomeReport(),
        HomeProfile(),
      ][currentPageIndex],
      floatingActionButton: Visibility(
        visible: currentPageIndex == 0 || currentPageIndex == 2 ? false : true,
        child: FloatingActionButton.extended(
          onPressed: () {},
          backgroundColor: const Color(0xFFcee4d2),
          label: Text(
            "Denunciar",
            style: GoogleFonts.inter(
                fontSize: 16.sp,
                color: const Color(0xFF2e4d34),
                fontWeight: FontWeight.w600),
          ),
          icon: const Icon(
            Icons.warning,
            color: Color(0xFF2e4d34),
          ),
        ),
      ),
    );
  }
}
