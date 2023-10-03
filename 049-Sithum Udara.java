import java.util.*;

class Order {

  private String orderId;
  private int phone_number;
  private String size;
  // private double price;
  private String order_status;
  private int qty;

  {
    order_status = "PROCESSING";
  }

  Order() {}

  Order(
    String orderId,
    int phone_number,
    String size,
    double price,
    String order_status,
    int qty
  ) {
    this.orderId = orderId;
    this.size = size;
    this.phone_number = phone_number;
    this.order_status = order_status;
    //this.price = price;
    this.qty = qty;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public void setPhoneNumber(int phone) {
    this.phone_number = phone;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public void setOrderStatus(String order_status) {
    this.order_status = order_status;
  }

  public String getOrderId() {
    return orderId;
  }

  public int getPhoneNumber() {
    return phone_number;
  }

  public String getSize() {
    return size;
  }

  public int getQty() {
    return qty;
  }

  public String getOrderStatus() {
    return order_status;
  }

  public boolean isIn(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (this.phone_number == arr[i]) {
        return true;
      }
    }
    return false;
  }
}

class Demo {

  public static Order[] orders = new Order[0];
  public static Scanner input = new Scanner(System.in);
  public static String[] sizes = { "XS", "S", "M", "L", "XL", "XXL" };
  public static int[] prices = { 600, 800, 900, 1000, 1100, 1200 };
  public static String tline =
    "+-------------------------------------------------------------------------------------------+ ";
  public static String change_order_status =
    "   _____ _          " +
    "                    " +
    " ____          _    " +
    "          _____ _   " +
    "     _             " +
    "\r\n" +
    "  / ____| |         " +
    "                    " +
    "/ __ \\        | |  " +
    "          / ____| | " +
    "     | |            " +
    "\r\n" +
    " | |    | |__   __ _" +
    " _ __   __ _  ___  |" +
    " |  | |_ __ __| | __" +
    "_ _ __  | (___ | |_ " +
    "__ _| |_ _   _ ___ " +
    "\r\n" +
    " | |    | \'_ \\ / _" +
    "` | \'_ \\ / _` |/ _" +
    " \\ | |  | | \'__/ _" +
    "` |/ _ \\ \'__|  \\_" +
    "__ \\| __/ _` | __| " +
    "| | / __|\r\n" +
    " | |____| | | | (_| " +
    "| | | | (_| |  __/ |" +
    " |__| | | | (_| |  _" +
    "_/ |     ____) | || " +
    "(_| | |_| |_| \\__ " +
    "\\\r\n" +
    "  \\_____|_| |_|\\__" +
    ",_|_| |_|\\__, |\\__" +
    "_|  \\____/|_|  \\__" +
    ",_|\\___|_|    |____" +
    "_/ \\__\\__,_|\\__|" +
    "\\__,_|___/\r\n" +
    "                    " +
    "        __/ |       " +
    "                    " +
    "                    " +
    "                   " +
    "\r\n" +
    "                    " +
    "       |___/        " +
    "                    " +
    "                    " +
    "                   " +
    "\r\n" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "--------------------";
  public static String sort_by_amount =
    "   _____            " +
    "_           _   _   " +
    "                    " +
    "                    " +
    "       _   \r\n" +
    "  / ____|          |" +
    " |         | | | |  " +
    "             /\\    " +
    "                    " +
    "       | |  \r\n" +
    " | (___   ___  _ __|" +
    " |_ ___  __| | | |__" +
    "  _   _     /  \\   " +
    "_ __ ___   ___  _   " +
    "_ _ __ | |_ \r\n" +
    "  \\___ \\ / _ \\| " +
    "\'__| __/ _ \\/ _` |" +
    " | \'_ \\| | | |   /" +
    " /\\ \\ | \'_ ` _ \\" +
    " / _ \\| | | | \'_ " +
    "\\| __|\r\n" +
    "  ____) | (_) | |  |" +
    " ||  __/ (_| | | |_)" +
    " | |_| |  / ____ \\|" +
    " | | | | | (_) | |_|" +
    " | | | | |_ \r\n" +
    " |_____/ \\___/|_|  " +
    " \\__\\___|\\__,_| |" +
    "_.__/ \\__, | /_/   " +
    " \\_\\_| |_| |_|\\__" +
    "_/ \\__,_|_| |_|\\__" +
    "|\r\n" +
    "                    " +
    "                    " +
    "   __/ |            " +
    "                    " +
    "           \r\n" +
    "                    " +
    "                    " +
    "  |___/             " +
    "                    " +
    "           \r\n\r\n" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "-----------";
  public static String order_report =
    "   ____          _  " +
    "           _____    " +
    "                   _" +
    "   \r\n" +
    "  / __ \\        | |" +
    "           |  __ \\ " +
    "                    " +
    "| |  \r\n" +
    " | |  | |_ __ __| | " +
    "___ _ __  | |__) |__" +
    "_ _ __   ___  _ __| " +
    "|_ \r\n" +
    " | |  | | \'__/ _` |" +
    "/ _ \\ \'__| |  _  /" +
    "/ _ \\ \'_ \\ / _ \\" +
    "| \'__| __|\r\n" +
    " | |__| | | | (_| | " +
    " __/ |    | | \\ \\ " +
    " __/ |_) | (_) | |  " +
    "| |_ \r\n" +
    "  \\____/|_|  \\__,_" +
    "|\\___|_|    |_|  \\" +
    "_\\___| .__/ \\___/|" +
    "_|   \\__|\r\n" +
    "                    " +
    "                    " +
    " | |                " +
    "   \r\n" +
    "                    " +
    "                    " +
    " |_|                " +
    "   \r\n\r\n" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "--------";
  public static String all_orders =
    "           _ _    __" +
    "__          _       " +
    "        \r\n" +
    "     /\\   | | |  / " +
    "__ \\        | |    " +
    "          \r\n" +
    "    /  \\  | | | | |" +
    "  | |_ __ __| | ___ " +
    "_ __ ___ \r\n" +
    "   / /\\ \\ | | | | " +
    "|  | | \'__/ _` |/ _" +
    " \\ \'__/ __|\r\n" +
    "  / ____ \\| | | | |" +
    "__| | | | (_| |  __/" +
    " |  \\__ \\\r\n" +
    " /_/    \\_\\_|_|  " +
    "\\____/|_|  \\__,_|" +
    "\\___|_|  |___/\r\n" +
    "                    " +
    "                    " +
    "        \r\n" +
    "                    " +
    "                    " +
    "        \r\n\r\n" +
    "--------------------" +
    "--------------------" +
    "------------";
  public static String sort_by_qty =
    "   _____            " +
    "_           _   _   " +
    "           ____ ____" +
    "_____     __\r\n" +
    "  / ____|          |" +
    " |         | | | |  " +
    "          / __ \\__ " +
    "  __\\ \\   / /\r\n" +
    " | (___   ___  _ __|" +
    " |_ ___  __| | | |__" +
    "  _   _  | |  | | | " +
    "|   \\ \\_/ / \r\n" +
    "  \\___ \\ / _ \\| " +
    "\'__| __/ _ \\/ _` |" +
    " | \'_ \\| | | | | |" +
    "  | | | |    \\   / " +
    " \r\n" +
    "  ____) | (_) | |  |" +
    " ||  __/ (_| | | |_)" +
    " | |_| | | |__| | | " +
    "|     | |   \r\n" +
    " |_____/ \\___/|_|  " +
    " \\__\\___|\\__,_| |" +
    "_.__/ \\__, |  \\___" +
    "\\_\\ |_|     |_|   " +
    "\r\n" +
    "                    " +
    "                    " +
    "   __/ |            " +
    "            \r\n" +
    "                    " +
    "                    " +
    "  |___/             " +
    "            \r\n\r\n" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "---------------";
  public static String order_by_amount =
    "   ____          _  " +
    "           ____     " +
    "                    " +
    "                    " +
    "  _   \r\n" +
    "  / __ \\        | |" +
    "           |  _ \\  " +
    "          /\\       " +
    "                    " +
    "    | |  \r\n" +
    " | |  | |_ __ __| | " +
    "___ _ __  | |_) |_  " +
    " _     /  \\   _ __ " +
    "___   ___  _   _ _ _" +
    "_ | |_ \r\n" +
    " | |  | | \'__/ _` |" +
    "/ _ \\ \'__| |  _ <|" +
    " | | |   / /\\ \\ | " +
    "\'_ ` _ \\ / _ \\| |" +
    " | | \'_ \\| __|\r\n" +
    " | |__| | | | (_| | " +
    " __/ |    | |_) | |_" +
    "| |  / ____ \\| | | " +
    "| | | (_) | |_| | | " +
    "| | |_ \r\n" +
    "  \\____/|_|  \\__,_" +
    "|\\___|_|    |____/ " +
    "\\__, | /_/    \\_\\" +
    "_| |_| |_|\\___/ \\_" +
    "_,_|_| |_|\\__|\r\n" +
    "                    " +
    "                  __" +
    "/ |                 " +
    "                    " +
    "      \r\n" +
    "                    " +
    "                 |__" +
    "_/                  " +
    "                    " +
    " \r\n" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "--------     ";
  public static String view_customers =
    " __      ___        " +
    "          _____     " +
    "     _              " +
    "                  \r" +
    "\n" +
    " \\ \\    / (_)     " +
    "           / ____|  " +
    "      | |           " +
    "                    " +
    "\r\n" +
    "  \\ \\  / / _  ____" +
    "_      __ | |    _  " +
    " _ ___| |_ ___  _ __" +
    " ___   ___ _ __ ___ " +
    "\r\n" +
    "   \\ \\/ / | |/ _ " +
    "\\ \\ /\\ / / | |   " +
    "| | | / __| __/ _ \\" +
    "| \'_ ` _ \\ / _ \\ " +
    "\'__/ __|\r\n" +
    "    \\  /  | |  __/" +
    "\\ V  V /  | |___| |" +
    "_| \\__ \\ || (_) | " +
    "| | | | |  __/ |  \\" +
    "__ \\\r\n" +
    "     \\/   |_|\\___|" +
    " \\_/\\_/    \\_____" +
    "\\__,_|___/\\__\\___" +
    "/|_| |_| |_|\\___|_|" +
    "  |___/\r\n" +
    "                    " +
    "                    " +
    "                    " +
    "                  \r" +
    "\n" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "------------------- ";
  public static String item_reports =
    "  _____ _           " +
    "        _____       " +
    "                _   " +
    "    \r\n" +
    " |_   _| |          " +
    "       |  __ \\     " +
    "                | | " +
    "     \r\n" +
    "   | | | |_ ___ _ __" +
    " ___   | |__) |___ _" +
    " __   ___  _ __| |_ " +
    "___ \r\n" +
    "   | | | __/ _ \\ \'" +
    "_ ` _ \\  |  _  // _" +
    " \\ \'_ \\ / _ \\| " +
    "\'__| __/ __|\r\n" +
    "  _| |_| ||  __/ | |" +
    " | | | | | \\ \\  __" +
    "/ |_) | (_) | |  | |" +
    "_\\__ \\\r\n" +
    " |_____|\\__\\___|_|" +
    " |_| |_| |_|  \\_\\_" +
    "__| .__/ \\___/|_|  " +
    " \\__|___/\r\n" +
    "                    " +
    "                  | " +
    "|                   " +
    "    \r\n" +
    "                    " +
    "                  |_" +
    "|                   " +
    "    \r\n\r\n" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "-----";
  public static String all_customer_reports =
    "           _ _    __" +
    "___          _      " +
    "                    " +
    "    _____           " +
    "            _       " +
    "\r\n" +
    "     /\\   | | |  / " +
    "____|        | |    " +
    "                    " +
    "    |  __ \\        " +
    "             | |    " +
    "  \r\n" +
    "    /  \\  | | | | |" +
    "    _   _ ___| |_ __" +
    "_  _ __ ___   ___ _ " +
    "__  | |__) |___ _ __" +
    "   ___  _ __| |_ ___" +
    " \r\n" +
    "   / /\\ \\ | | | | " +
    "|   | | | / __| __/ " +
    "_ \\| \'_ ` _ \\ / _" +
    " \\ \'__| |  _  // _" +
    " \\ \'_ \\ / _ \\| " +
    "\'__| __/ __|\r\n" +
    "  / ____ \\| | | | |" +
    "___| |_| \\__ \\ || " +
    "(_) | | | | | |  __/" +
    " |    | | \\ \\  __/" +
    " |_) | (_) | |  | |_" +
    "\\__ \\\r\n" +
    " /_/    \\_\\_|_|  " +
    "\\_____\\__,_|___/\\" +
    "__\\___/|_| |_| |_|" +
    "\\___|_|    |_|  \\_" +
    "\\___| .__/ \\___/|_" +
    "|   \\__|___/\r\n" +
    "                    " +
    "                    " +
    "                    " +
    "              | |   " +
    "                    " +
    "\r\n" +
    "                    " +
    "                    " +
    "                    " +
    "              |_|   " +
    "                    " +
    "\r\n\r\n" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "-";
  public static String best_in_customers =
    "  ____            _ " +
    "    _____          _" +
    "____          _     " +
    "                    " +
    "       \r\n" +
    " |  _ \\          | " +
    "|   |_   _|        /" +
    " ____|        | |   " +
    "                    " +
    "        \r\n" +
    " | |_) | ___  ___| |" +
    "_    | |  _ __   | |" +
    "    _   _ ___| |_ __" +
    "_  _ __ ___   ___ _ " +
    "__ ___ \r\n" +
    " |  _ < / _ \\/ __| " +
    "__|   | | | \'_ \\  " +
    "| |   | | | / __| __" +
    "/ _ \\| \'_ ` _ \\ /" +
    " _ \\ \'__/ __|\r\n" +
    " | |_) |  __/\\__ \\" +
    " |_   _| |_| | | | |" +
    " |___| |_| \\__ \\ |" +
    "| (_) | | | | | |  _" +
    "_/ |  \\__ \\\r\n" +
    " |____/ \\___||___/" +
    "\\__| |_____|_| |_| " +
    " \\_____\\__,_|___/" +
    "\\__\\___/|_| |_| |_" +
    "|\\___|_|  |___/\r\n" +
    "\r\n" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "-------\r\n" +
    "                    " +
    "                    " +
    "                    " +
    "                    " +
    "       \r\n" +
    "                    " +
    "                    " +
    "                    " +
    "                    " +
    "       ";
  public static String customer_reports =
    "\r\n" +
    "   _____          _ " +
    "                    " +
    "         _____      " +
    "                 _  " +
    "     \r\n" +
    "  / ____|        | |" +
    "                    " +
    "        |  __ \\    " +
    "                 | |" +
    "      \r\n" +
    " | |    _   _ ___| |" +
    "_ ___  _ __ ___   __" +
    "_ _ __  | |__) |___ " +
    "_ __   ___  _ __| |_" +
    " ___ \r\n" +
    " | |   | | | / __| _" +
    "_/ _ \\| \'_ ` _ \\ " +
    "/ _ \\ \'__| |  _  /" +
    "/ _ \\ \'_ \\ / _ \\" +
    "| \'__| __/ __|\r\n" +
    " | |___| |_| \\__ \\" +
    " || (_) | | | | | | " +
    " __/ |    | | \\ \\ " +
    " __/ |_) | (_) | |  " +
    "| |_\\__ \\\r\n" +
    "  \\_____\\__,_|___/" +
    "\\__\\___/|_| |_| |_" +
    "|\\___|_|    |_|  \\" +
    "_\\___| .__/ \\___/|" +
    "_|   \\__|___/\r\n" +
    "                    " +
    "                    " +
    "                   |" +
    " |                  " +
    "     \r\n" +
    "                    " +
    "                    " +
    "                   |" +
    "_|                  " +
    "\r\n" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "------     ";
  public static String reports =
    "  _____             " +
    "          _       \r" +
    "\n" +
    " |  __ \\           " +
    "          | |      " +
    "\r\n" +
    " | |__) |___ _ __   " +
    "___  _ __| |_ ___ \r" +
    "\n" +
    " |  _  // _ \\ \'_ " +
    "\\ / _ \\| \'__| __/" +
    " __|\r\n" +
    " | | \\ \\  __/ |_) " +
    "| (_) | |  | |_\\__ " +
    "\\\r\n" +
    " |_|  \\_\\___| .__/" +
    " \\___/|_|   \\__|__" +
    "_/\r\n" +
    "            | |     " +
    "                  \r" +
    "\n" +
    "            |_|     " +
    "                \r\n" +
    "--------------------" +
    "-------------------";

  public static String delete_order =
    "  _____       _     " +
    " _          ____    " +
    "      _           \r" +
    "\n" +
    " |  __ \\     | |   " +
    " | |        / __ \\ " +
    "       | |          " +
    "\r\n" +
    " | |  | | ___| | ___" +
    "| |_ ___  | |  | |_ " +
    "__ __| | ___ _ __ \r" +
    "\n" +
    " | |  | |/ _ \\ |/ _" +
    " \\ __/ _ \\ | |  | " +
    "| \'__/ _` |/ _ \\ " +
    "\'__|\r\n" +
    " | |__| |  __/ |  __" +
    "/ ||  __/ | |__| | |" +
    " | (_| |  __/ |   \r" +
    "\n" +
    " |_____/ \\___|_|\\_" +
    "__|\\__\\___|  \\___" +
    "_/|_|  \\__,_|\\___|" +
    "_|   \r\n" +
    "                    " +
    "                    " +
    "                  \r" +
    "\n" +
    "--------------------" +
    "--------------------" +
    "------------------";
  //////SEARCH ORDER STRING
  public static String search_order =
    " _____              " +
    "       _       _____" +
    "         _          " +
    " \r\n" +
    "/  ___|             " +
    "      | |     |  _  " +
    "|       | |         " +
    " \r\n" +
    "\\ `--.  ___  __ _ _" +
    " __ ___| |__   | | |" +
    " |_ __ __| | ___ _ _" +
    "_ \r\n" +
    " `--. \\/ _ \\/ _` |" +
    " \'__/ __| \'_ \\  |" +
    " | | | \'__/ _` |/ _" +
    " \\ \'__|\r\n" +
    "/\\__/ /  __/ (_| | " +
    "| | (__| | | | \\ \\" +
    "_/ / | | (_| |  __/ " +
    "|   \r\n" +
    "\\____/ \\___|\\__,_" +
    "|_|  \\___|_| |_|  " +
    "\\___/|_|  \\__,_|\\" +
    "___|_|   \r\n" +
    "                    " +
    "                    " +
    "                    " +
    " \r\n" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "-";
  //////SEARCH CUSTOMER STRING
  public static String search_customer =
    "   _____            " +
    "         _       ___" +
    "__           _      " +
    "                    " +
    "  \r\n" +
    "  /  ___|           " +
    "        | |     /  _" +
    "_ \\         | |    " +
    "                    " +
    "   \r\n" +
    "  \\ `--.  ___  __ _" +
    " _ __ ___| |__   | /" +
    "  \\/_   _ ___| |_ _" +
    "__  _ __ ___   ___ _" +
    " __ \r\n" +
    "   `--. \\/ _ \\/ _`" +
    " | \'__/ __| \'_ \\ " +
    " | |   | | | / __| _" +
    "_/ _ \\| \'_ ` _ \\ " +
    "/ _ \\ \'__|\r\n" +
    "  /\\__/ /  __/ (_| " +
    "| | | (__| | | | | " +
    "\\__/\\ |_| \\__ \\ " +
    "|| (_) | | | | | |  " +
    "__/ |   \r\n" +
    "  \\____/ \\___|\\__" +
    ",_|_|  \\___|_| |_| " +
    " \\____/\\__,_|___/" +
    "\\__\\___/|_| |_| |_" +
    "|\\___|_|   \r\n" +
    "                    " +
    "                    " +
    "                    " +
    "                    " +
    "\r\n" +
    "--------------------" +
    "--------------------" +
    "--------------------" +
    "--------------------";

  //////PLACE ORDER STRING
  public static String place_order =
    "  ______ _          " +
    "        _____       " +
    "  _           \r\n" +
    "  | ___ \\ |        " +
    "        |  _  |     " +
    "  | |          \r\n" +
    "  | |_/ / | __ _  __" +
    "_ ___  | | | |_ __ _" +
    "_| | ___ _ __ \r\n" +
    "  |  __/| |/ _` |/ _" +
    "_/ _ \\ | | | | \'__" +
    "/ _` |/ _ \\ \'__|\r" +
    "\n" +
    "  | |   | | (_| | (_" +
    "|  __/ \\ \\_/ / | |" +
    " (_| |  __/ |   \r\n" +
    "  \\_|   |_|\\__,_|" +
    "\\___\\___|  \\___/|" +
    "_|  \\__,_|\\___|_| " +
    "  \r\n" +
    "                    " +
    "                    " +
    "            \r\n" +
    "--------------------" +
    "--------------------" +
    "------------";

  public static String Fashion_Shop =
    "                 /$$" +
    "$$$$$$              " +
    "   /$$       /$$    " +
    "                    " +
    "    /$$$$$$  /$$    " +
    "                    " +
    "  \r\n" +
    "                | $$" +
    "_____/              " +
    "  | $$      |__/    " +
    "                    " +
    "   /$$__  $$| $$    " +
    "                    " +
    "  \r\n" +
    "                | $$" +
    "    /$$$$$$   /$$$$$" +
    "$$| $$$$$$$  /$$  /$" +
    "$$$$$  /$$$$$$$     " +
    "  | $$  \\__/| $$$$$" +
    "$$   /$$$$$$   /$$$$" +
    "$$ \r\n" +
    "                | $$" +
    "$$$|____  $$ /$$____" +
    "_/| $$__  $$| $$ /$$" +
    "__  $$| $$__  $$    " +
    "  |  $$$$$$ | $$__  " +
    "$$ /$$__  $$ /$$__  " +
    "$$\r\n" +
    "                | $$" +
    "__/ /$$$$$$$|  $$$$$" +
    "$ | $$  \\ $$| $$| $" +
    "$  \\ $$| $$  \\ $$ " +
    "      \\____  $$| $$" +
    "  \\ $$| $$  \\ $$| " +
    "$$  \\ $$\r\n" +
    "                | $$" +
    "   /$$__  $$ \\____ " +
    " $$| $$  | $$| $$| $" +
    "$  | $$| $$  | $$   " +
    "    /$$  \\ $$| $$  " +
    "| $$| $$  | $$| $$  " +
    "| $$\r\n" +
    "                | $$" +
    "  |  $$$$$$$ /$$$$$$" +
    "$/| $$  | $$| $$|  $" +
    "$$$$$/| $$  | $$    " +
    "  |  $$$$$$/| $$  | " +
    "$$|  $$$$$$/| $$$$$$" +
    "$/\r\n" +
    "                |__/" +
    "   \\_______/|______" +
    "_/ |__/  |__/|__/ \\" +
    "______/ |__/  |__/  " +
    "     \\______/ |__/ " +
    " |__/ \\______/ | $$" +
    "____/ \r\n" +
    "                    " +
    "                    " +
    "                    " +
    "                    " +
    "                    " +
    "            | $$    " +
    "  \r\n" +
    "                    " +
    "                    " +
    "                    " +
    "                    " +
    "                    " +
    "            | $$    " +
    "  \r\n" +
    "                    " +
    "                    " +
    "                    " +
    "                    " +
    "                    " +
    "            |__/    " +
    "  \r\n" +
    "                ====" +
    "====================" +
    "====================" +
    "====================" +
    "====================" +
    "====================" +
    "=====";

  public static void main(String args[]) {
    String main_menu =
      "\n\t\t\t[1] Place Order\t\t\t\t\t[2] Search cuntomer \n\t\t\t[3] Search Order \t\t\t\t[4] View Reports \n\t\t\t[5] Change Order Status \t\t\t[6] Delete Order";

    addToLast("ODR#000001", 704601484, "XS", "Processing", 11);
    addToLast("ODR#000002", 704601484, "M", "Processing", 12);
    addToLast("ODR#000003", 704601484, "S", "Processing", 13);
    addToLast("ODR#000004", 715337858, "XL", "Processing", 14);
    addToLast("ODR#000005", 715337858, "L", "Processing", 15);
    addToLast("ODR#000006", 715337858, "XXL", "Processing", 16);

    L1:while (true) {
      clearConsole();
      System.out.println(Fashion_Shop);

      System.out.println(main_menu);

      System.out.print("Input option : ");

      int op1 = input.nextInt();

      switch (op1) {
        case 1:
          placeOrder();
          break;
        case 2:
          searchCustomer();
          break;
        case 3:
          searchOrder();
          break;
        case 4:
          viewReports();
          break;
        case 5:
          changeOrderStatus();
          break;
        case 6:
          deleteOrder();
          break;
        default:
          continue L1;
      }
    }
  }

  static void placeOrder() {
    clearConsole();
    System.out.println(place_order);
    String orderId = createOrderId((orders.length) + 1);
    System.out.println("Enter ORDER ID  :" + orderId);
    // METHOD VARIABLES
    int phone = 0;
    String size = "";
    int qty = 0;
    //THESE PARTS CONTAIN VALIDATION AND OTHER OPERATIONS----1

    char ta = 'n';
    // PHONE NUMBER INPUT
    do {
      // works only in the second time run
      if ((String.valueOf(ta).toLowerCase()).equals("y")) {
        for (int i = 0; i < 2; i++) {
          System.out.print("\033[1A");
          System.out.print("\033[0J");
        }
      }
      ta = 'n';

      System.out.print("Enter customer phone number : ");
      phone = input.nextInt();
      if (String.valueOf(phone).length() != 9) {
        System.out.print(
          "phone number is invalid do you want to enter another (Y/N) : "
        );
        ta = input.next().charAt(0);
        if ((String.valueOf(ta).toLowerCase()).equals("n")) {
          return;
        }
      } else {
        if (String.valueOf(phone).charAt(0) != '7') {
          System.out.print(
            "phone number is invalid do you want to enter another (Y/N) : "
          );
          ta = input.next().charAt(0);
          if ((String.valueOf(ta).toLowerCase()).equals("n")) {
            return;
          }
        }
      }
    } while ((String.valueOf(ta).toLowerCase()).equals("y"));

    // T_SHIRT SIZE INPUT
    do {
      input.nextLine();
      // works only in the second time run
      if ((String.valueOf(ta).toLowerCase()).equals("y")) {
        for (int i = 0; i < 2; i++) {
          System.out.print("\033[1A");
          System.out.print("\033[0J");
        }
      }
      ta = 'n';
      boolean isinsizes = false;

      System.out.print("Enter T-Shirt size (XS/S/M/L/XL/XXL) : ");
      size = input.nextLine();
      // --check whether in sizes
      L2:for (String i : sizes) {
        if (size.equals(i)) {
          isinsizes = true;
          break L2;
        }
      }

      if (!isinsizes) {
        System.out.print(
          "input is not valid do you want to enter another (Y/N) : "
        );
        ta = input.next().charAt(0);
        if ((String.valueOf(ta).toLowerCase()).equals("n")) {
          return;
        }
      }
    } while ((String.valueOf(ta).toLowerCase()).equals("y"));

    // INPUT THE QUANTITY
    do {
      // works only in the second time run
      if ((String.valueOf(ta).toLowerCase()).equals("y")) {
        for (int i = 0; i < 2; i++) {
          System.out.print("\033[1A");
          System.out.print("\033[0J");
        }
      }
      ta = 'n';
      System.out.print("Enter the QTY : ");
      qty = input.nextInt();
      if (qty <= 0) {
        System.out.print(
          "input is not valid do you want to enter another (Y/N) : "
        );
        ta = input.next().charAt(0);
      }
    } while ((String.valueOf(ta).toLowerCase()).equals("y"));

    System.out.println();

    System.out.println("AMOUNT : " + calculateAmount(size, qty));

    System.out.print("\n\nDo you want to place this order (Y/N) :");
    char ch = input.next().charAt(0);
    input.nextLine();
    if (String.valueOf(ch).toUpperCase().equals("Y")) {
      //ADDING TO THE DATABSE
      addToLast(orderId, phone, size, "Processing", qty);

      System.out.println("order Placed..!");
    }

    System.out.print("\n\n\tDo you want to place Another order (Y/N) :");
    ch = input.next().charAt(0);
    if (String.valueOf(ch).toUpperCase().equals("Y")) {
      placeOrder();
    }
  }

  public static void searchCustomer() {
    String table_head = "+--------+---------+------------+\r\n";

    int phone = 0;
    char ch = 'n';
    char ta = 'n';
    do {
      clearConsole();
      System.out.println(search_customer);
      //works only in the second time run
      if ((String.valueOf(ta).toLowerCase()).equals("y")) {
        for (int i = 0; i < 2; i++) {
          System.out.print("\033[1A");
          System.out.print("\033[0J");
        }
      }
      ta = 'n';
      System.out.print("Enter customer phone number : ");
      phone = input.nextInt();
      if (String.valueOf(phone).length() != 9 || !(isIn(phone))) {
        System.out.print(
          "phone number is invalid do you want to enter another (Y/N) : "
        );
        ta = input.next().charAt(0);
        if ((String.valueOf(ta).toLowerCase()).equals("n")) {
          return;
        }
      }
    } while ((String.valueOf(ta).toLowerCase()).equals("y"));
    //getting the index list Sithum Udara
    int[] index_list = indexesOfElement(phone);
    System.out.println("\n\n");
    System.out.printf(table_head);

    System.out.printf("|%8s|", "size");
    System.out.printf("%9s|", "QTY");
    System.out.printf("%12s|\r\n", "Amount");
    System.out.printf(table_head);
    int total = 0;
    for (int i = 0; i < sizes.length; i++) {
      int subtotal = 0;
      for (int j : index_list) {
        if (orders[j].getSize() == null) {
          System.out.println("theres no data to show yet");
          System.out.print("press any key+enter to homepage ");
          input.next();

          return;
        } else if (orders[j].getSize().equals(sizes[i])) {
          subtotal += orders[j].getQty();
        }
      }

      System.out.printf("|%8s|", sizes[i]);
      System.out.printf("%9s|", subtotal);
      System.out.printf("%12s|\r\n", (subtotal * prices[i]));
      total += (subtotal * prices[i]);
    }

    System.out.print(table_head);
    System.out.printf("| %17s|", "total amount");
    System.out.printf("%12s|%n", String.valueOf(total));
    System.out.print(table_head);

    //for(int i=0;i<index_list.length;i++){
    //index_list[i]
    System.out.print("\n\n\tDo you want to search Another customer (Y/N) :");
    ch = input.next().charAt(0);
    if (String.valueOf(ch).toUpperCase().equals("Y")) {
      searchCustomer();
    }
  }

  public static void searchOrder() {
    String order = "";
    char ch = 'n';
    char ta = 'n';
    do {
      clearConsole();
      System.out.println(search_order);
      //works only in the second time run
      if ((String.valueOf(ta).toLowerCase()).equals("y")) {
        for (int i = 0; i < 2; i++) {
          System.out.print("\033[1A");
          System.out.print("\033[0J");
        }
      }
      ta = 'n';
      System.out.print("Enter the Order ID : ");
      input.nextLine();
      order = input.nextLine();

      if (String.valueOf(order).length() != 10 || !isIn(order)) {
        //-------------WAnna try again-------------!!!!!!!!
        System.out.print(
          "Order ID is invalid do you want to enter another (Y/N) : "
        );
        ta = input.next().charAt(0);
        if ((String.valueOf(ta).toLowerCase()).equals("n")) {
          return;
        }
      }
    } while ((String.valueOf(ta).toLowerCase()).equals("y"));

    int idx = findIndex(order);

    if (idx != -1) {
      System.out.println(
        "\n\t\t Phone number   : " + orders[idx].getPhoneNumber()
      );
      System.out.println("\n\t\t Size\t\t: " + orders[idx].getSize());
      System.out.println("\n\t\t QTY  \t\t: " + orders[idx].getQty());
      System.out.println(
        "\n\t\t Amount\t\t: " +
        calculateAmount(orders[idx].getSize(), orders[idx].getQty())
      );
      System.out.println(
        "\n\t\t Status\t\t:" + orders[idx].getOrderStatus() + "\n\n\n"
      );
    } else {
      System.out.println("wrong ID");
    }

    System.out.print("Do you want to search another Order (Y/N) :");
    ch = input.next().charAt(0);
    if (String.valueOf(ch).toUpperCase().equals("Y")) {
      searchOrder();
    }
  }

  public static void viewReports() {
    String viewreport_menu =
      "\n\t\t\t[1] Customer Report\n\n\t\t\t[2] Item reports \n\n\t\t\t[3] Order Reports";
    L1:while (true) {
      clearConsole();
      System.out.println(reports);
      System.out.println(viewreport_menu);
      System.out.print("Enter Option : ");
      int op2 = input.nextInt();

      switch (op2) {
        case 1:
          customerReports();
          break;
        case 2:
          itemReports();
          break;
        case 3:
          orderReports();
          break;
        default:
          continue L1;
      }
    }
  }

  public static void customerReports() {
    String customer_reports_menu =
      "\n\t\t\t[1]Best in Customers\n\n\t\t\t[2] view customers \n\n\t\t\t[3] All customers Reports";
    L1:while (true) {
      clearConsole();
      System.out.println(customer_reports);
      System.out.println(customer_reports_menu);
      System.out.print("Enter Option : ");
      int op2 = input.nextInt();

      switch (op2) {
        case 1:
          bestInCustomers();
          break;
        case 2:
          viewCustomers();
          break;
        //case 3: allCustomersReports();break;
        default:
          continue L1;
      }
    }
  }

  public static void bestInCustomers() {
    clearConsole();
    System.out.println(best_in_customers);
    String table_head = "+----------+-----------+-------------+\r";

    //Creation of the arrays that will hold the amount and qty for each phone number
    int[] sorted_phone_numbers = new int[0];
    int[] amount_array = new int[0];
    int[] sorted_qty = new int[0];
    //going through the every object phone number and creating places for them at in new arrays and putting them at where they belong.
    for (int i = 0, j = 0; i < orders.length; i++) {
      if (!orders[i].isIn(sorted_phone_numbers)) {
        sorted_phone_numbers = increaseLen(sorted_phone_numbers);
        amount_array = increaseLen(amount_array);
        sorted_qty = increaseLen(sorted_qty);
        sorted_phone_numbers[j] = orders[i].getPhoneNumber();
        sorted_qty[j] = orders[i].getQty();
        amount_array[j] =
          prices[findIndex(orders[i].getSize(), sizes)] * orders[i].getQty();
        j++;
      } else if (orders[i].isIn(sorted_phone_numbers)) {
        int spot = findIndex(orders[i].getPhoneNumber(), sorted_phone_numbers);
        sorted_qty[spot] += orders[i].getQty();
        amount_array[spot] +=
          prices[findIndex(orders[i].getSize(), sizes)] * orders[i].getQty();
      }
    }

    sorted_qty = changeSequence(findSortSequence(amount_array), sorted_qty);
    sorted_phone_numbers =
      changeSequence(findSortSequence(amount_array), sorted_phone_numbers);
    amount_array = changeSequence(findSortSequence(amount_array), amount_array);

    System.out.println(table_head);
    System.out.printf("|%10s|", "User ID");
    System.out.printf("%9s  |", "QTY");
    System.out.printf("%12s |\r\n", "Amount");
    System.out.println(table_head);

    for (int i = 0; i < amount_array.length; i++) {
      System.out.printf("|%10s|", sorted_phone_numbers[i]);
      System.out.printf("%9s  |", sorted_qty[i]);
      System.out.printf("%12s |\r\n", amount_array[i]);
    }
    System.out.println(table_head + "\n\n");

    System.out.print("\n\n\t to return to homepage press enter any value :");
    char ch = input.next().charAt(0);
  }

  public static void viewCustomers() {
    clearConsole();
    System.out.println(view_customers);
    String table_head = "+----------+-----------+-------------+\r";

    //Creation of the arrays that will hold the amount and qty for each phone number
    int[] sorted_phone_numbers = new int[0];
    int[] amount_array = new int[0];
    int[] sorted_qty = new int[0];

    //loop through each unique phone number
    for (int i = 0, j = 0; i < orders.length; i++) {
      if (!orders[i].isIn(sorted_phone_numbers)) {
        sorted_phone_numbers = increaseLen(sorted_phone_numbers);
        amount_array = increaseLen(amount_array);
        sorted_qty = increaseLen(sorted_qty);
        sorted_phone_numbers[j] = orders[i].getPhoneNumber();
        sorted_qty[j] = orders[i].getQty();
        amount_array[j] =
          prices[findIndex(orders[i].getSize(), sizes)] * orders[i].getQty();
        j++;
      } else if (orders[i].isIn(sorted_phone_numbers)) {
        int spot = findIndex(orders[i].getPhoneNumber(), sorted_phone_numbers);
        sorted_qty[spot] += orders[i].getQty();
        amount_array[spot] +=
          prices[findIndex(orders[i].getSize(), sizes)] * orders[i].getQty();
      }
    }

    System.out.println(table_head);
    System.out.printf("|%10s|", "User ID");
    System.out.printf("%9s  |", "QTY");
    System.out.printf("%12s |\r\n", "Amount");
    System.out.println(table_head);

    for (int i = 0; i < amount_array.length; i++) {
      System.out.printf("|%10s|", sorted_phone_numbers[i]);
      System.out.printf("%9s  |", sorted_qty[i]);
      System.out.printf("%12s |\r\n", amount_array[i]);
    }
    System.out.println(table_head + "\n\n");

    System.out.print("\n\n\t to return to homepage press enter any value :");
    char ch = input.next().charAt(0);
  }

  public static void allCustomersReports() {
    clearConsole();
    System.out.println(all_customer_reports);
    String table_head =
      "+--------------+-----+-----+-----+-----+-----+-----+--------------+\r";
    System.out.println(table_head);
    System.out.printf("| %10S |", "Phone Number");
    for (String size : sizes) {
      System.out.printf(" %3S |", size);
    }
    System.out.printf(" %12S |%n", "Total");
    System.out.println(table_head);

    //Creation of the arrays that will hold the amount and qty for each phone number
    int[] sorted_phone_numbers = new int[0];
    int[] amount_array = new int[0];
    //going through the every object phone number and creating places for them at in new arrays and putting them at where they belong.
    for (int i = 0, j = 0; i < orders.length; i++) {
      if (!orders[i].isIn(sorted_phone_numbers)) {
        sorted_phone_numbers = increaseLen(sorted_phone_numbers);
        amount_array = increaseLen(amount_array);

        sorted_phone_numbers[j] = orders[i].getPhoneNumber();
        amount_array[j] =
          prices[findIndex(orders[i].getSize(), sizes)] * orders[i].getQty();
        j++;
      } else if (orders[i].isIn(sorted_phone_numbers)) {
        int spot = findIndex(orders[i].getPhoneNumber(), sorted_phone_numbers);
        amount_array[spot] +=
          prices[findIndex(orders[i].getSize(), sizes)] * orders[i].getQty();
      }
    }
    for (int phone : sorted_phone_numbers) {
      int total = 0;
      //this array stores each size for the ID
      int c = 0;
      //create the array for each sizes qty
      int[] sorted_size_qtys = new int[sizes.length];
      //run through sizes and calculate qty in each of them
      for (String each : sizes) {
        int current_running_size_qty = 0;
        for (int i : indexesOfElement(phone)) {
          if (each.equals(orders[i].getSize())) {
            current_running_size_qty += orders[i].getQty();
            total += orders[i].getQty() * prices[findIndex(each, sizes)];
          }
        }
        sorted_size_qtys[c] = current_running_size_qty;
        c++;
      }
      //print the value into the table after arrangement

      System.out.printf("| %12s |", phone);
      for (int size : sorted_size_qtys) {
        System.out.printf(" %3S |", size);
      }
      System.out.printf(" %12S |%n", total);
    }
    System.out.println(table_head + "\n\n");

    System.out.print("\n\n\t to return to homepage press enter any value :");
    char ch = input.next().charAt(0);
  }

  public static void itemReports() {
    String item_reports_menu =
      "\n\t\t [1] Best selling categories sorted by quantity \n\n\t\t [2] Best selling items sorted by amount";
    L1:while (true) {
      clearConsole();
      System.out.println(item_reports);
      System.out.println(item_reports_menu);
      System.out.print("Enter the option : ");
      int op2 = input.nextInt();
      switch (op2) {
        case 1:
          itemSortByQty();
          break;
        case 2:
          itemSortByAmnt();
          break;
        default:
          break;
      }
    }
  }

  public static void itemSortByQty() {
    clearConsole();
    System.out.println(sort_by_qty);
    int[] sorted_qty_array = new int[sizes.length];
    String[] sorted_sizes = new String[sizes.length];
    int[] sorted_amount = new int[sizes.length];
    for (int i = 0; i < sizes.length; i++) {
      sorted_sizes[i] = sizes[i];
    }
    for (int i = 0; i < sizes.length; i++) {
      for (int j : indexesOfElement(sizes[i])) {
        sorted_qty_array[i] += orders[j].getQty();
        sorted_amount[i] += prices[i] * orders[j].getQty();
      }
    }
    //System.out.println("Unsorted Array"+Arrays.toString(sorted_qty_array));
    //System.out.println("Unsorted Array"+Arrays.toString(sorted_sizes));
    //System.out.println("unsorted Array"+Arrays.toString(sorted_amount));
    //System.out.println("Sort Sequence"+Arrays.toString(findSortSequence(sorted_qty_array)));
    //System.out.println("When array is changed"+Arrays.toString(changeSequence(findSortSequence(sorted_qty_array),sorted_qty_array)));

    sorted_amount =
      changeSequence(findSortSequence(sorted_qty_array), sorted_amount);
    sorted_sizes =
      changeSequence(findSortSequence(sorted_qty_array), sorted_sizes);
    sorted_qty_array =
      changeSequence(findSortSequence(sorted_qty_array), sorted_qty_array);

    //Creating the table
    String table_head = "+------------+-----------+---------------------+";
    System.out.println(table_head);
    System.out.printf("| %9s  |", "SIZE");
    System.out.printf(" %8s  |", "QTY");
    System.out.printf(" %18s  |%n", "Total Amount");
    System.out.println(table_head);
    //System.out.println(Arrays.toString(sorted_qty_array));
    //System.out.println("sorted sizes array"+Arrays.toString(sorted_sizes));
    //System.out.println(Arrays.toString(sorted_amount));
    for (int i = 0; i < sorted_sizes.length; i++) {
      System.out.printf("| %9s  |", sorted_sizes[i]);
      System.out.printf(" %8s  |", sorted_qty_array[i]);
      System.out.printf(" %18s  |%n", sorted_amount[i]);
    }
    System.out.println(table_head);

    System.out.print("\n\n\t to return to homepage press enter any value :");
    char ch = input.next().charAt(0);
  }

  public static void itemSortByAmnt() {
    clearConsole();
    System.out.println(sort_by_qty);
    int[] sorted_qty_array = new int[sizes.length];
    String[] sorted_sizes = new String[sizes.length];
    int[] sorted_amount = new int[sizes.length];
    for (int i = 0; i < orders.length; i++) {
      sorted_amount[i] =
        orders[i].getQty() * prices[findIndex(orders[i].getSize(), sizes)];
    }
    for (int i = 0; i < sizes.length; i++) {
      sorted_sizes[i] = sizes[i];
    }
    for (int i = 0; i < sizes.length; i++) {
      for (int j : indexesOfElement(sizes[i])) {
        sorted_qty_array[i] += orders[j].getQty();
        sorted_amount[i] += prices[i] * orders[j].getQty();
      }
    }
    //System.out.println("Unsorted Array"+Arrays.toString(sorted_qty_array));
    //System.out.println("Unsorted Array"+Arrays.toString(sorted_sizes));
    //System.out.println("unsorted Array"+Arrays.toString(sorted_amount));
    //System.out.println("Sort Sequence"+Arrays.toString(findSortSequence(sorted_qty_array)));
    //System.out.println("When array is changed"+Arrays.toString(changeSequence(findSortSequence(sorted_qty_array),sorted_qty_array)));

    sorted_sizes =
      changeSequence(findSortSequence(sorted_amount), sorted_sizes);
    sorted_qty_array =
      changeSequence(findSortSequence(sorted_amount), sorted_qty_array);
    sorted_amount =
      changeSequence(findSortSequence(sorted_qty_array), sorted_amount);

    //Creating the table
    String table_head = "+------------+-----------+---------------------+";
    System.out.println(table_head);
    System.out.printf("| %9s  |", "SIZE");
    System.out.printf(" %8s  |", "QTY");
    System.out.printf(" %18s  |%n", "Total Amount");
    System.out.println(table_head);
    //System.out.println(Arrays.toString(sorted_qty_array));
    //System.out.println("sorted sizes array"+Arrays.toString(sorted_sizes));
    //System.out.println(Arrays.toString(sorted_amount));
    for (int i = 0; i < sorted_sizes.length; i++) {
      System.out.printf("| %9s  |", sorted_sizes[i]);
      System.out.printf(" %8s  |", sorted_qty_array[i]);
      System.out.printf(" %18s  |%n", sorted_amount[i]);
    }
    System.out.println(table_head);

    System.out.print("\n\n\t to return to homepage press enter any value :");
    char ch = input.next().charAt(0);
  }

  public static void orderReports() {
    clearConsole();
    System.out.println(order_report);

    String order_reports_menu =
      "\n\t\t[1] All Orders \n\t\t[2] Orders By Amount";
    System.out.println(order_reports_menu);

    System.out.print("Enter Option :");
    int op2 = input.nextInt();
    switch (op2) {
      case 1:
        allOrders();
        break;
      case 2:
        ordersByAmnt();
        break;
      default:
        orderReports();
    }
    System.out.println("\n\nTo Access Main Menu , please Enter 0 : ");
    char ch = input.next().charAt(0);
  }

  public static void allOrders() {
    clearConsole();
    System.out.println(all_orders);
    String table_head =
      "+------------------+-----------------+-------------+-------------+--------------------+----------------------+";
    System.out.println(table_head);
    System.out.printf("| %15S  |", "Order ID");
    System.out.printf(" %14S  |", "Customer ID");
    System.out.printf(" %10S  |", "Size");
    System.out.printf(" %10S  |", "QTY");
    System.out.printf(" %17S  |", "Amount");
    System.out.printf(" %19S  |%n", "Status");
    System.out.println(table_head);
    for (int i = orders.length - 1; i >= 0; i--) {
      System.out.printf("| %15S  |", orders[i].getOrderId());
      System.out.printf(" %14S  |", orders[i].getPhoneNumber());
      System.out.printf(" %10S  |", orders[i].getSize());
      System.out.printf(" %10S  |", orders[i].getQty());
      System.out.printf(
        " %17S  |",
        prices[findIndex(orders[i].getSize(), sizes)] * orders[i].getQty()
      );
      System.out.printf(" %19S  |%n", orders[i].getOrderStatus());
    }
    System.out.println(table_head);
    System.out.println("\n\nTo Access Main Menu , please Enter 0 : ");
    char ch = input.next().charAt(0);
  }

  public static void ordersByAmnt() {
    int length = orders.length;
    String[] sorted_order_array = new String[length];
    int[] sorted_phone_numbers = new int[length];
    String[] sorted_sizes_array = new String[length];
    int[] sorted_qty_array = new int[length];
    int[] sorted_amount_array = new int[length];
    String[] sorted_order_status = new String[length];

    for (int i = 0; i < length; i++) {
      sorted_amount_array[i] =
        prices[findIndex(orders[i].getSize(), sizes)] * orders[i].getQty();
      sorted_order_array[i] = orders[i].getOrderId();
      sorted_phone_numbers[i] = orders[i].getPhoneNumber();
      sorted_sizes_array[i] = orders[i].getSize();
      sorted_qty_array[i] = orders[i].getQty();
      sorted_order_status[i] = orders[i].getOrderStatus();
    }

    //sorting process
    int[] seq = findSortSequence(sorted_amount_array);
    sorted_order_array = changeSequence(seq, sorted_order_array);
    sorted_phone_numbers = changeSequence(seq, sorted_phone_numbers);
    sorted_qty_array = changeSequence(seq, sorted_qty_array);
    sorted_sizes_array = changeSequence(seq, sorted_sizes_array);
    sorted_amount_array = changeSequence(seq, sorted_amount_array);
    sorted_order_status = changeSequence(seq, sorted_order_status);

    //printing process
    String table_head =
      "+------------------+-----------------+-------------+-------------+--------------------+----------------------+";
    System.out.println(table_head);
    System.out.printf("| %15S  |", "Order ID");
    System.out.printf(" %14S  |", "Customer ID");
    System.out.printf(" %10S  |", "Size");
    System.out.printf(" %10S  |", "QTY");
    System.out.printf(" %17S  |", "Amount");
    System.out.printf(" %19S  |%n", "Status");
    System.out.println(table_head);
    for (int i = 0; i < length; i++) {
      System.out.printf("| %15S  |", sorted_order_array[i]);
      System.out.printf(" %14S  |", sorted_phone_numbers[i]);
      System.out.printf(" %10S  |", sorted_qty_array[i]);
      System.out.printf(" %10S  |", sorted_sizes_array[i]);
      System.out.printf(" %17S  |", sorted_amount_array[i]);
      System.out.printf(" %19S  |%n", sorted_order_status[i]);
    }
    System.out.println(table_head);
    System.out.println("\n\nTo Access Main Menu , please Enter 0 : ");
    char ch = input.next().charAt(0);
  }

  public static void changeOrderStatus() {
    String order = "";
    char ch = 'n';
    char ta = 'n';
    do {
      clearConsole();
      System.out.println(change_order_status);
      //works only in the second time run
      if ((String.valueOf(ta).toLowerCase()).equals("y")) {
        for (int i = 0; i < 2; i++) {
          System.out.print("\033[1A");
          System.out.print("\033[0J");
        }
      }
      ta = 'n';
      System.out.print("Enter the Order ID : ");
      input.nextLine();
      order = input.nextLine();

      if (String.valueOf(order).length() != 10 || !isIn(order)) {
        //-------------WAnna try again-------------!!!!!!!!
        System.out.print(
          "Order ID is invalid do you want to enter another (Y/N) : "
        );
        ta = input.next().charAt(0);
        if ((String.valueOf(ta).toLowerCase()).equals("n")) {
          return;
        }
      }
    } while ((String.valueOf(ta).toLowerCase()).equals("y"));

    int idx = findIndex(order);

    if (idx != -1) {
      System.out.println(
        "\n\t\t Phone number   : " + orders[idx].getPhoneNumber()
      );
      System.out.println("\n\t\t Size\t\t: " + orders[idx].getSize());
      System.out.println("\n\t\t QTY  \t\t: " + orders[idx].getQty());
      System.out.println(
        "\n\t\t Amount\t\t: " +
        orders[idx].getQty() *
        prices[findIndex(orders[idx].getSize(), sizes)]
      );
      System.out.println(
        "\n\t\t Status\t\t: " + orders[idx].getOrderStatus() + "\n\n\n"
      );
    } else {
      System.out.println("wrong ID");
    }
    if (orders[idx].getOrderStatus().equals("Processing")) {
      System.out.print("Do you want to change this Order status ( Y/N) :");
      ch = input.next().charAt(0);
      if (String.valueOf(ch).toUpperCase().equals("Y")) {
        System.out.println(
          "\n\t\t[1] Order Delivering \n\t\t[2] Order Delivered"
        );
        System.out.print("Enter Option : ");
        int ch2 = input.nextInt();
        switch (ch2) {
          case 1:
            orders[idx].setOrderStatus("Delivering");
            System.out.println("\n\n\t\tStatus Updated !...");
            break;
          case 2:
            orders[idx].setOrderStatus("Delivered");
            System.out.println("\n\n\t\tStatus Updated !...");
            break;
          default:
            System.out.println("invalid Option");
        }
      }
    } else if (orders[idx].getOrderStatus().equals("Delivering")) {
      System.out.print("Do you want to change this Order status ( Y/N) :");
      ch = input.next().charAt(0);
      if (String.valueOf(ch).toUpperCase().equals("Y")) {
        System.out.println("\n\t\t[1] Order Delivered");
        System.out.print("Enter Option : ");
        int ch2 = input.nextInt();
        switch (ch2) {
          case 1:
            orders[idx].setOrderStatus("Delivered");
            System.out.println("\n\n\t\tStatus Updated !...");
            break;
          default:
            System.out.println("invalid Option");
        }
      }
    } else {
      System.out.print("can't change this order!!! Already delivered... :");
    }
    System.out.print("Do you want to change another order status  (Y/N): ");
    ch = input.next().charAt(0);
    if (String.valueOf(ch).toUpperCase().equals("Y")) {
      changeOrderStatus();
    }
  }

  public static void deleteOrder() {
    String order = "";
    char ch = 'n';
    char ta = 'n';
    do {
      clearConsole();
      System.out.println(delete_order);
      //works only in the second time run
      if ((String.valueOf(ta).toLowerCase()).equals("y")) {
        for (int i = 0; i < 2; i++) {
          System.out.print("\033[1A");
          System.out.print("\033[0J");
        }
      }
      ta = 'n';
      System.out.print("Enter the Order ID : ");
      input.nextLine();
      order = input.nextLine();

      if (String.valueOf(order).length() != 10 || !isIn(order)) {
        //-------------WAnna try again-------------!!!!!!!!
        System.out.print(
          "Order ID is invalid do you want to enter another (Y/N) : "
        );
        ta = input.next().charAt(0);
        if ((String.valueOf(ta).toLowerCase()).equals("n")) {
          return;
        }
      }
    } while ((String.valueOf(ta).toLowerCase()).equals("y"));

    int idx = findIndex(order);

    if (idx != -1) {
      System.out.println(
        "\n\t\t Phone number   : " + orders[idx].getPhoneNumber()
      );
      System.out.println("\n\t\t Size\t\t: " + orders[idx].getSize());
      System.out.println("\n\t\t QTY  \t\t: " + orders[idx].getQty());
      System.out.println(
        "\n\t\t Amount\t\t: " +
        orders[idx].getQty() *
        prices[findIndex(orders[idx].getSize(), sizes)]
      );
      System.out.println(
        "\n\t\t Status\t\t: " + orders[idx].getOrderStatus() + "\n\n\n"
      );
      ////REmoving the order from the arrays.
      System.out.print("Do you want to Delete this order (Y/N) : ");
      ch = input.next().charAt(0);
      if (String.valueOf(ch).toUpperCase().equals("Y")) {
        deleteOrder(idx);
        System.out.println("\n\n\t\tDone Order Deleted....!");
      }
    } else {
      System.out.println("wrong ID");
    }

    System.out.print("Do you want to Delete another Order (Y/N) :");
    ch = input.next().charAt(0);
    if (String.valueOf(ch).toUpperCase().equals("Y")) {
      deleteOrder();
    }
  }

  public static String createOrderId(int num) {
    String orderID = "" + num;
    for (String i = "0"; 5 >= orderID.length();) {
      orderID = i + orderID;
    }
    orderID = "ODR#" + orderID;
    return orderID;
  }

  public static int calculateAmount(String s, int q) {
    int amount = prices[findIndex(s, sizes)] * q;
    return amount;
  }

  public static int findIndex(String orderId) {
    for (int i = 0; i < orders.length; i++) {
      if (orders[i].getOrderId().equals(orderId)) {
        return i;
      }
    }
    return -1;
  }

  public static int findIndex(int num, int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == num) {
        return i;
      }
    }
    return -1;
  }

  public static int findIndex(String val, String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (val.equals(arr[i])) {
        return i;
      }
    }
    return -1;
  }

  public static final void clearConsole() {
    try {
      final String os = System.getProperty("os.name");
      if (os.contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    } catch (final Exception e) {
      e.printStackTrace();
      // Handle any exceptions.
    }
  }

  public static int[] increaseLen(int[] arr) {
    int[] temp = new int[arr.length + 1];
    for (int i = 0; i < arr.length; i++) {
      temp[i] = arr[i];
    }
    return temp;
  }

  public static String[] increaseLen(String[] arr) {
    String[] temp = new String[arr.length];
    for (int i = 0; i < arr.length; i++) {
      temp[i] = arr[i];
    }
    return temp;
  }

  public static void increaseLen() {
    Order[] tempArr = new Order[orders.length + 1];

    for (int i = 0; i < orders.length; i++) {
      tempArr[i] = orders[i];
    }
    orders = tempArr;
  }

  public static void addToLast(
    String orderId,
    int phone_number,
    String size,
    String order_status,
    int qty
  ) {
    increaseLen();
    orders[orders.length - 1] = new Order();
    System.out.println(orders.length);
    System.out.println(phone_number);
    System.out.println(size);

    orders[orders.length - 1].setPhoneNumber(phone_number);
    orders[orders.length - 1].setSize(size);
    orders[orders.length - 1].setOrderStatus(order_status);
    orders[orders.length - 1].setQty(qty);
    orders[orders.length - 1].setOrderId(orderId);
  }

  public static boolean isIn(int num) {
    for (int i = 0; i < orders.length; i++) {
      if (orders[i].getPhoneNumber() == num) {
        return true;
      }
    }
    return false;
  }

  public static boolean isIn(String str) {
    for (int i = 0; i < orders.length; i++) {
      if (str.equals(orders[i].getOrderId())) {
        return true;
      }
    }
    return false;
  }

  public static int[] indexesOfElement(int num) {
    int[] temp = new int[0];
    for (int i = 0, j = 0; i < orders.length; i++) {
      if (orders[i].getPhoneNumber() == num) {
        temp = increaseLen(temp);
        temp[j] = i;
        j++;
      }
    }
    return temp;
  }

  public static boolean isIn(int num, int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == num) {
        return true;
      }
    }
    return false;
  }

  public static int[] findSortSequence(int ar[]) {
    int[] temp_ar = new int[ar.length];
    for (int i = 0; i < ar.length; i++) {
      temp_ar[i] = ar[i];
    }
    int[] sort_sequence = new int[temp_ar.length];
    for (int i = 0; i < temp_ar.length - 1; i++) {
      for (int j = i + 1; j < temp_ar.length; j++) {
        if (temp_ar[i] < temp_ar[j]) {
          int temp = temp_ar[i];
          temp_ar[i] = temp_ar[j];
          temp_ar[j] = temp;
        }
      }
    }
    L1:for (int i = 0; i < temp_ar.length; i++) {
      L2:for (int j = 0; j < temp_ar.length; j++) {
        if (ar[i] == temp_ar[j]) {
          if (isIn(j, sort_sequence)) {
            continue L2;
          }
          sort_sequence[i] = j;
          continue L1;
        }
      }
    }

    return sort_sequence;
  }

  public static int[] changeSequence(int[] sequence, int[] arr) {
    int[] temp = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      temp[sequence[i]] = arr[i];
    }
    return temp;
  }

  public static String[] changeSequence(int[] sequence, String[] arr) {
    String[] temp = new String[arr.length];
    for (int i = 0; i < arr.length; i++) {
      temp[sequence[i]] = arr[i];
    }
    return temp;
  }

  public static int[] indexesOfElement(String num) {
    int[] temp = new int[0];
    for (int i = 0, j = 0; i < orders.length; i++) {
      if (orders[i].getSize().equals(num)) {
        temp = increaseLen(temp);
        temp[j] = i;
        j++;
      }
    }
    return temp;
  }

  public static void deleteOrder(int idx) {
    for (int i = idx; i < orders.length - 1; i++) {
      orders[i] = orders[i + 1];
    }

    //TO SHORT THE ORDERS ARRAY
    Order[] tempOrders = new Order[orders.length - 1];

    for (int i = 0; i < tempOrders.length; i++) {
      tempOrders[i] = orders[i];
    }
    orders = tempOrders;
  }
}
