public class MenuDriver
{
	public static void menuTypeSelector(int menuType)
		{
			if (menuType == 1)
				Menu.displayAdminMenu();
			else if (menuType == 0)
				Menu.displayUserMenu();
		}

}