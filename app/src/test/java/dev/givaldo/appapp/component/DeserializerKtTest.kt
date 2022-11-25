package dev.givaldo.appapp.component

import org.junit.Assert.*

class DeserializerKtTest {

    val json = "{\n" +
            "  \"card\": [\n" +
            "    {\n" +
            "      \"padding\": {\n" +
            "        \"top\": 10,\n" +
            "        \"bottom\": 10,\n" +
            "        \"end\": 10,\n" +
            "        \"start\": 10\n" +
            "      },\n" +
            "      \"radius\": 18,\n" +
            "      \"column\": [\n" +
            "        {\n" +
            "          \"image\": {\n" +
            "            \"height\": 0,\n" +
            "            \"width\": 200,\n" +
            "            \"path\": \"http://url\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"spacer\": {\n" +
            "            \"width\": 0,\n" +
            "            \"height\": 24\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"row\": [\n" +
            "            {\n" +
            "              \"text\": {\n" +
            "                \"value\": \"A custom Store\",\n" +
            "                \"size\": 18,\n" +
            "                \"weight\": \"SEMI_BOLD\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"spacer\": {\n" +
            "                \"width\": 24,\n" +
            "                \"height\": 0\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"text\": {\n" +
            "                \"value\": \"A custom Store\",\n" +
            "                \"size\": 16,\n" +
            "                \"weight\": \"NORMAL\"\n" +
            "              }\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}"
}