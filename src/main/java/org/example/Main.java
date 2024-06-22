package org.example;

import com.github.javafaker.Faker;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;
import java.lang.*;
import java.util.*;
import org.example.utils.Numbergen;

public class Main {
    static int day = 23;


    public static String email(String vorname, String nachname) {
        Random rand = new Random();
        String email = "";
        //lemme cook email---------------

        String[] mailEndings = {
                "@gmail.com",       // Google Mail
                "@gmx.de",          // GMX
                "@gmx.net",         // GMX
                "@web.de",          // Web.de
                "@t-online.de",     // Deutsche Telekom
                "@yahoo.de",        // Yahoo
                "@outlook.com",     // Microsoft Outlook
                "@hotmail.com",     // Microsoft Hotmail
                "@live.com",        // Microsoft Live
                "@freenet.de",      // Freenet
                "@arcor.de",        // Arcor (Vodafone)
                "@posteo.de",       // Posteo
                "@mail.de",         // Mail.de
                "@icloud.com",      // Apple iCloud
                "@online.de",       // 1&1 (United Internet)
                "@protonmail.com",  // ProtonMail
                "@aol.de",          // AOL
                "@t-online.com",
                "@hornymail.xxx"// Deutsche Telekom (alternative Endung)
        };

        String mailMiddle[] = {
                "-",
                "_",
                "",
                "",
                "."
        };

        String randNumberEnding = "";
        if (rand.nextInt(4) == 1) {
            randNumberEnding = String.valueOf(rand.nextInt(200));
        }

        email = vorname + mailMiddle[rand.nextInt(mailMiddle.length - 1)] + nachname + randNumberEnding + mailEndings[rand.nextInt(mailEndings.length - 1)];
        //-------------------------------
        return email;
    }

    public static String[] addItem(String[] myArray, String x) {
        int i;
        //turn array into ArrayList using asList() method
        List arrList = new ArrayList(Arrays.asList(myArray));

        // adding a new element to the array
        arrList.add(x);

        // Transforming the ArrayList into an array
        myArray = (String[]) arrList.toArray(myArray);
        return myArray;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Faker faker = new Faker(new Locale("de"));
        Random rand = new Random();
        Numbergen ng = new Numbergen();
        String[] times = {};

        for (int i = 0; i < 7; i++) {
            Integer day2 = day + i;
            for (int y = 0; y < 13; y++) {


                Integer hour = 10;
                hour += y;

                String tm = "2024-06-" + String.valueOf(day2) + "T" + hour + ":00:00+02:00";
                times = addItem(times, tm);

            }
        }
    /*
    List<String> strList = Arrays.asList(times);
    Collections.shuffle(strList);
    times = strList.toArray(new String[strList.size()]);

    */
        System.out.println(Arrays.toString(times));

        for (String time : times) {
            new Thread(() -> {
            String Vorname = faker.name().firstName();
            String Nachname = faker.name().lastName();
            //String email = Vorname+ "." + Nachname + String.format("%04d", rand.nextInt(10000)) + "@web.de";
            String email = Main.email(Vorname, Nachname);
            String Tel = ng.getNumber();
            System.out.println(Vorname);
            System.out.println(Nachname);
            System.out.println(email);
            System.out.println(Tel);
            System.out.println(time);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://calendly.com/api/booking/invitees"))
                    .header("cookie", "__cf_bm=TRVC99Y4ERoXEBTUXC8GslHmC.icO6DhciUWDDfS7oY-1719062940-1.0.1.1-kf7mElwz.AB3MME.ckuMeNHIPVvwOWw15b_ZMGtGEytK4qneFEfjXe74WhBDIcafOBkYIeKn_M_llTQurX62DA; __cfruid=06b7628f9274b2769cd3fa94af14b373965cf28a-1719062940; _cfuvid=4.BLNzP_41mjdRK8cFhuJ.hoVbG4P0c2qHd5DwSHT3E-1719062940861-0.0.1.1-604800000; calendly_idd_id_35964daa-8a4e-493d-a2c2-5cdd8d36ee35=f87FohbbU%252FR%252F0b%252F%252F%252B7Wr9kK0J4pAY%252BDXPUidUMqZY%252B0zPjvL2o8g0NryGLFGKNywBl4GZXi1D1IC4pCfz6GAwh1KsadcYG5HloBraE7GqV0NPrLa0faLLqBDQxaXUDlrJdvZS%252BA0FJsLJrBXrOblTFhseU89ax0boYX2VidbFwNkjynnGQV2nh8nWABMZ7D4d%252F8jwtixZGsAioePbJeJYxQR17Q8TV%252FxoXvnfVTaoNTLoELznY6N95rG--mSaAe6LjGoVK69Sf--%252FUqE%252Fup6A86wt2W1bI7njw%253D%253D; _calendly_session=50NWJDdhovo978ECslAauJzl4gX%252Buyk96hK5grBntHz7rZcfQQMKFJCxYl8OSjuzMuEuTRZgQg13tuGAcNMzatzpewpRxisWzYWe722ZFvopO28kNQixNhJdfFZeatanDR0v7McGLL9c3XTmMmv53%252BDIMLgvA1lq%252BniRPlrpizPAvBS8zIkss6G3ZfIjGvxjF8sm6aY8BBg9DPi7Zq9sbiHprOhhr4AAhY6pmYaSdduqIyBVRtmdvaFWxCKq9TNx4Dcqs8Rr7BbJSixhwwmZ--RVcDfMYxGY9XViR6--g%252FnuBnqr10cWsBK4gAcVig%253D%253D")
                    .header("Content-Type", "application/json")
                    .header("User-Agent", "insomnia/8.5.1")
                    .method("POST", HttpRequest.BodyPublishers.ofString("{\n    \"analytics\": {\n        \"referrer_page\": null,\n        \"invitee_landed_at\": \"2024-06-22T13:29:53.729Z\",\n        \"browser\": \"Chrome 126\",\n        \"device\": \"undefined Windows 10\",\n        \"fields_filled\": 4,\n        \"fields_presented\": 2,\n        \"booking_flow\": \"v3\",\n        \"seconds_to_convert\": 17\n    },\n    \"embed\": {\n        \"domain\": \"robertprissmann.com\",\n        \"type\": \"Inline\",\n        \"hide_details\": false,\n        \"color_customization\": true\n    },\n    \"event\": {\n        \"start_time\": \"" + time + "\",\n        \"location_configuration\": {\n            \"location\": \"\",\n            \"phone_number\": \"\",\n            \"additional_info\": \"\"\n        },\n        \"guests\": {}\n    },\n    \"event_fields\": [\n        {\n            \"id\": 149696102,\n            \"name\": \"Telefonnummer:\",\n            \"format\": \"phone_number\",\n            \"required\": true,\n            \"position\": 0,\n            \"answer_choices\": null,\n            \"include_other\": false,\n            \"value\": \"" + Tel + "\",\n            \"extension\": null,\n            \"isValid\": true,\n            \"countryCode\": \"de\"\n        },\n        {\n            \"id\": 149695384,\n            \"name\": \"Dieses Meeting findet auf Zoom statt. Du findest den Link in deiner Bestätigungs-Email. Wenn du nicht zum Gespräch mit mir erscheinst, kannst du es NICHT erneut planen. \",\n            \"format\": \"choices_many\",\n            \"required\": true,\n            \"position\": 1,\n            \"answer_choices\": [\n                \"Ja, ich werde pünktlich da sein.\",\n                \"Ich verstehe es nicht und benötige Hilfe.\"\n            ],\n            \"include_other\": false,\n            \"value\": \"Ich verstehe es nicht und benötige Hilfe.\"\n        }\n    ],\n    \"invitee\": {\n        \"timezone\": \"Europe/Berlin\",\n        \"time_notation\": \"24h\",\n        \"first_name\": \"" + Vorname + "\",\n        \"last_name\": \"" + Nachname + "\",\n        \"email\": \"" + email + "\"\n    },\n    \"payment_token\": {},\n    \"recaptcha_token\": \"03AFcWeA4AYgrd3sZvn_EydutrOysvwL6j1XGg1DDQNUAINj-tYoYJ_WO-4fB8bD9qWvs1ojLVztT4itLlELaox3NNdfz4KZ7WJoxumfPcCqNCQSES2Oc-inmwh8gO_ucF0WIrcouhfX0VPdc1di2wWWACmzVsj2BD4LXAjbPZWwZdX_G-kXxYxcliQVaw3Mfrnuq6vmHqoRQlHfYOi_jwlz6F4Rm9tfYECiPId8-JiLKAna8uINuTpbXkiD6wjQFNgL6IpV0ZJUZshB5H7XF_LtTl1aS74NBpbVQOQR_iYq-0kL9tnAcK0QVbX-Jtc5mNn3hAoMR8OGmZ27CG0mdALd0R8yFQ6C8Pn8NAnt8mv7s9zBQfWhDG5i6f-oHRJ7snCXhLbTO96MMPUfkLZXVpK2KRsH56yVWRljv-ar4fxywFA-wJ2K7ouG_4CD92rG8pJoRyclceVUKtbLEipDUQSwE-_HDupFLOVVAALPuoUgRxDrbnCYPdSLNNShnAbl6ZF5eBtFpI_5UdtC_PI_vjbHuTaRLpRw6s-jgkogAyYVx6smZH9CUXt9OnzXRRzweOppPD2U_rk_H4ZdJT3oJiAdlL8O177a0w-VjKrxIF9uNgMJ2QvlrmYaN61eOVcKVUOYS2toMWnYz2OCVYBOc57srARUcBQsYrFhSMMGwZ6quUyifz5qTpAsBN0kkSs8lAbQxbJWLuEmL_qv5PScDJ4JqhsrpWaxDCkWDLuPUYb2aMxRMaDMPEiKer9CL-XKeoeCR3Ey3HRn7wA2x3zaErHciaoSfjEt6glHcumv4MyG6TZio7RjjyF9mJMtx4I4tUEi9B60A_jM8ausA5nH9aaDFjL1fWnqfQ7NoxWwClGNoYj39iANtIY8c4F35Vm_y_goyzH9F_oS5iRo85Mg-WWsUwyPvZ3X3TPPtpmpGxeWc2zbpHBkfSv3Z-M8nTipGxjNOZ8VvrdDrXp4K9PkHl3gm8EEwOOSPDHhjhYe6rZdesAkotIKAZPttqZcgbjCda3GJEuVJXHfFTMgc2hPrvQkmKmMNsIgZfXuvzO0BDOdrsuSOAWPxRHaRWQ8pwHDwauD_JzF8uYtdwuUqOs589oHutK_nuwsfElEAwSH-qCr_svZhfpEhJ5y5ps_GAZZ-2VBlz8dyMFX4MeALxUTLVYgH6F4Xe03OdRNasFgd73EWF194AZIEJbsKBA7lk7F7NIt1Mmav7E73piZdWI0ns8EOU4mPzddfXM5o8YtoVYhcS2pVOZzQmYInpLFumPSLEVcMn__ampvcWDReYZgGU5CNOpyaxmIrnZZg6Uyo8uAH8LFT9xpL-sFtcdd8VAYDBCVsHkxt_LhkMfxe3tDBWMUxpLUSzvpFbZCpMAziNWkFPv9luin8LCLSOCPKvRtncSWUbCT7BmLuVMwCpg12M34vUjDuc2wqCT8rfjG8rSfFLeUEng18JGPQjsPhgmdb0Ot6nffKignySBy8-uGoYTaWWOADc3SCrVWfUThexo57_Hk0oHm4IABnkjIOIIWqUdMELrblmvKRQ2xzZ0_G3Sb3ojuiP0hWx05V-EHobZtCBBfqZpigO3s1OxpWQfAjHIyCZW0pDMRqzpEMiIBMAwLV9DaerihzkDdHiIYaI_mFdHfniSntPkuVgfACvgnCPbJX8p8LvU5u64vRZK2nTEuGb8UewRMWPmCAqrLaVGw5iK0NjhJ7ITCinUwwzOx3C3feeGoali02ye1hyokZ-IaOhoACHrIHLCqY0RzwoiAri04t11g29xDquJ2dASPfDOQUZp5KEee1h2RDIrknfzSUdiDCviHp2kxTAVmPVUKzRnvU90Ta55C14RkkNlQS9CuqdXprmOxGFfpn_w0cMx4x1GOCJuB7kIGQ0AYPsFc0DjMTzyE-pqapsalSUL1PnFCQyq78T_B8W7B-gZjhCAcb7mmc86LH7B2gEG7n6f51VnLdyBBTG8AVQqN-0XgSt1waJsxvZke2i65y7NUdR3U4ZJxX5M3Oex8421HnJ2R64Zwphc7K0_sje8VgGc_irxqAiZB9yfG_7zxltBjrRs359Y04g6vcit1McA5svnscg7aZdeMDIn-Ez9ES46hpToFgDRhl5HF3bp6p_RaaEzadpkuGutWXD7EdpkWoEjrxEEm38XFw1iv3KoA7iSA7dDaqQOlJA580KZMYfqQb5qJGvkzPw7Pi6TFJDYqylH3fBWykCGwkOpSlTvd6FLNJ3V-xYJZ8EJwj_Ty-3lc-eiPzVNGK_8h0cgPYkvMk2CDIFk6ruUlQ6zbqNYNf6cWQm_kXsq3Nvjn7wtDJwUhXAVSYS-HZv30nBC9usJ-LrbmCjobdncpK2wnsUCUGkPQhkb2VuP15BlNDRk0wJcWgZv-TAFHlr_Py4-B2TLegWvIBf8OO5X-toyJPBHnV3hA5QQXTOEc5s-NiPnXc0b8MZA5B7i9hy9-BUZJPzaCIKW-iuy2H5Hd1bWKumVXsudcJae4VgEfJWrrY9BWHkB3r12-9gSw0pNA6QO1jEIvU60VJFj8V0ni0Hq_3Ahj22mYtcnPjroHtDU-J6AtACsLBAuLBMgNDrQKnDHOzejcRnQRr3v-n8EHrzelG24SJu4nGNj4012-ILweN8SF1WfdzB1vYBiFumH4xAN0Sn_Q2mvV35A3qGRDnajo8aWBiBie_lV-f74BfvcWrqMDWtSLSGo68EjM8-Z6LfMlJ0lkWrnoKrAbV7Qy5fStzW2RLmKiu3_QF6x9HgniJBFvmY7KKTzXszdxiDRf-_GRX_FA226QySWeTYtCwpteoUtpCVVR2WnnUekhzuJSdigymT9nONzZmCtgmY2yaqhsFUzKkLIlPY99r-X1MExPUvGcCIMWMpKU1Hep5JwzohhiQBTD05yeHIPkrqAAjBuFTxeD2-IPtmEkIQB_FDXziix9IsG5Zvlt2tOlHSStQvU4BVGJKdIwaNgB2K8ug-HQdzMkGFlrf1IT65UmUdePX7HrCLO7vO5ANqhYo5v7DW2mWQuUx9Ala35CimghIVtKNkjyKwoQZ9H694PXrFGf-rrEpPI5EctotY0_UQoWEn7ZZyh4Rjg1tlrUsGbgAHdQgGNIuWWT3-WuOGPtTTAa1TqiLPQEgadiDH1HC18yZwrXUw4I31cbErhcVS1hQgmDumcuoLlGQRVJkPthlBTylkJjjVzKUlBEkl57DL8abyQflSiRe_INPz_S7yXDmPOIsjJVuUh-0bHC-T6CuhCuZU-TmfUqXpXbxZ201wTDuCbOs5OHPc1GvwClz4FDqo2Q\",\n    \"tracking\": {\n        \"fingerprint\": \"45d12416701bfe9a38a14f429905ba02\",\n        \"utm_campaign\": \"_____\",\n        \"utm_source\": \"_____\",\n        \"utm_medium\": \"_____\",\n        \"utm_content\": \"_____\",\n        \"utm_term\": \"_____\",\n        \"salesforce_uuid\": \"VIBEMedia\"\n    },\n    \"scheduling_link_uuid\": \"yq9-9gm-2wf\",\n    \"locale\": \"de\"\n}"))
                    .build();
                HttpResponse<String> response = null;
                try {
                    response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(response.body());

            Vorname = faker.name().firstName();
            Nachname = faker.name().lastName();
            //String email = Vorname+ "." + Nachname + String.format("%04d", rand.nextInt(10000)) + "@web.de";
            email = email(Vorname, Nachname);
            Tel = ng.getNumber();
            System.out.println(Vorname);
            System.out.println(Nachname);
            System.out.println(email);
            System.out.println(Tel);

            request = HttpRequest.newBuilder()
                    .uri(URI.create("https://calendly.com/api/booking/invitees"))
                    .header("cookie", "__cf_bm=TRVC99Y4ERoXEBTUXC8GslHmC.icO6DhciUWDDfS7oY-1719062940-1.0.1.1-kf7mElwz.AB3MME.ckuMeNHIPVvwOWw15b_ZMGtGEytK4qneFEfjXe74WhBDIcafOBkYIeKn_M_llTQurX62DA; __cfruid=06b7628f9274b2769cd3fa94af14b373965cf28a-1719062940; _cfuvid=4.BLNzP_41mjdRK8cFhuJ.hoVbG4P0c2qHd5DwSHT3E-1719062940861-0.0.1.1-604800000; calendly_idd_id_35964daa-8a4e-493d-a2c2-5cdd8d36ee35=f87FohbbU%252FR%252F0b%252F%252F%252B7Wr9kK0J4pAY%252BDXPUidUMqZY%252B0zPjvL2o8g0NryGLFGKNywBl4GZXi1D1IC4pCfz6GAwh1KsadcYG5HloBraE7GqV0NPrLa0faLLqBDQxaXUDlrJdvZS%252BA0FJsLJrBXrOblTFhseU89ax0boYX2VidbFwNkjynnGQV2nh8nWABMZ7D4d%252F8jwtixZGsAioePbJeJYxQR17Q8TV%252FxoXvnfVTaoNTLoELznY6N95rG--mSaAe6LjGoVK69Sf--%252FUqE%252Fup6A86wt2W1bI7njw%253D%253D; _calendly_session=50NWJDdhovo978ECslAauJzl4gX%252Buyk96hK5grBntHz7rZcfQQMKFJCxYl8OSjuzMuEuTRZgQg13tuGAcNMzatzpewpRxisWzYWe722ZFvopO28kNQixNhJdfFZeatanDR0v7McGLL9c3XTmMmv53%252BDIMLgvA1lq%252BniRPlrpizPAvBS8zIkss6G3ZfIjGvxjF8sm6aY8BBg9DPi7Zq9sbiHprOhhr4AAhY6pmYaSdduqIyBVRtmdvaFWxCKq9TNx4Dcqs8Rr7BbJSixhwwmZ--RVcDfMYxGY9XViR6--g%252FnuBnqr10cWsBK4gAcVig%253D%253D")
                    .header("Content-Type", "application/json")
                    .header("User-Agent", "insomnia/8.5.1")
                    .method("POST", HttpRequest.BodyPublishers.ofString("{\n    \"analytics\": {\n        \"referrer_page\": null,\n        \"invitee_landed_at\": \"2024-06-22T13:29:53.729Z\",\n        \"browser\": \"Chrome 126\",\n        \"device\": \"undefined Windows 10\",\n        \"fields_filled\": 4,\n        \"fields_presented\": 2,\n        \"booking_flow\": \"v3\",\n        \"seconds_to_convert\": 17\n    },\n    \"embed\": {\n        \"domain\": \"robertprissmann.com\",\n        \"type\": \"Inline\",\n        \"hide_details\": false,\n        \"color_customization\": true\n    },\n    \"event\": {\n        \"start_time\": \"" + time + "\",\n        \"location_configuration\": {\n            \"location\": \"\",\n            \"phone_number\": \"\",\n            \"additional_info\": \"\"\n        },\n        \"guests\": {}\n    },\n    \"event_fields\": [\n        {\n            \"id\": 149696102,\n            \"name\": \"Telefonnummer:\",\n            \"format\": \"phone_number\",\n            \"required\": true,\n            \"position\": 0,\n            \"answer_choices\": null,\n            \"include_other\": false,\n            \"value\": \"" + Tel + "\",\n            \"extension\": null,\n            \"isValid\": true,\n            \"countryCode\": \"de\"\n        },\n        {\n            \"id\": 149695384,\n            \"name\": \"Dieses Meeting findet auf Zoom statt. Du findest den Link in deiner Bestätigungs-Email. Wenn du nicht zum Gespräch mit mir erscheinst, kannst du es NICHT erneut planen. \",\n            \"format\": \"choices_many\",\n            \"required\": true,\n            \"position\": 1,\n            \"answer_choices\": [\n                \"Ja, ich werde pünktlich da sein.\",\n                \"Ich verstehe es nicht und benötige Hilfe.\"\n            ],\n            \"include_other\": false,\n            \"value\": \"Ich verstehe es nicht und benötige Hilfe.\"\n        }\n    ],\n    \"invitee\": {\n        \"timezone\": \"Europe/Berlin\",\n        \"time_notation\": \"24h\",\n        \"first_name\": \"" + Vorname + "\",\n        \"last_name\": \"" + Nachname + "\",\n        \"email\": \"" + email + "\"\n    },\n    \"payment_token\": {},\n    \"recaptcha_token\": \"03AFcWeA4AYgrd3sZvn_EydutrOysvwL6j1XGg1DDQNUAINj-tYoYJ_WO-4fB8bD9qWvs1ojLVztT4itLlELaox3NNdfz4KZ7WJoxumfPcCqNCQSES2Oc-inmwh8gO_ucF0WIrcouhfX0VPdc1di2wWWACmzVsj2BD4LXAjbPZWwZdX_G-kXxYxcliQVaw3Mfrnuq6vmHqoRQlHfYOi_jwlz6F4Rm9tfYECiPId8-JiLKAna8uINuTpbXkiD6wjQFNgL6IpV0ZJUZshB5H7XF_LtTl1aS74NBpbVQOQR_iYq-0kL9tnAcK0QVbX-Jtc5mNn3hAoMR8OGmZ27CG0mdALd0R8yFQ6C8Pn8NAnt8mv7s9zBQfWhDG5i6f-oHRJ7snCXhLbTO96MMPUfkLZXVpK2KRsH56yVWRljv-ar4fxywFA-wJ2K7ouG_4CD92rG8pJoRyclceVUKtbLEipDUQSwE-_HDupFLOVVAALPuoUgRxDrbnCYPdSLNNShnAbl6ZF5eBtFpI_5UdtC_PI_vjbHuTaRLpRw6s-jgkogAyYVx6smZH9CUXt9OnzXRRzweOppPD2U_rk_H4ZdJT3oJiAdlL8O177a0w-VjKrxIF9uNgMJ2QvlrmYaN61eOVcKVUOYS2toMWnYz2OCVYBOc57srARUcBQsYrFhSMMGwZ6quUyifz5qTpAsBN0kkSs8lAbQxbJWLuEmL_qv5PScDJ4JqhsrpWaxDCkWDLuPUYb2aMxRMaDMPEiKer9CL-XKeoeCR3Ey3HRn7wA2x3zaErHciaoSfjEt6glHcumv4MyG6TZio7RjjyF9mJMtx4I4tUEi9B60A_jM8ausA5nH9aaDFjL1fWnqfQ7NoxWwClGNoYj39iANtIY8c4F35Vm_y_goyzH9F_oS5iRo85Mg-WWsUwyPvZ3X3TPPtpmpGxeWc2zbpHBkfSv3Z-M8nTipGxjNOZ8VvrdDrXp4K9PkHl3gm8EEwOOSPDHhjhYe6rZdesAkotIKAZPttqZcgbjCda3GJEuVJXHfFTMgc2hPrvQkmKmMNsIgZfXuvzO0BDOdrsuSOAWPxRHaRWQ8pwHDwauD_JzF8uYtdwuUqOs589oHutK_nuwsfElEAwSH-qCr_svZhfpEhJ5y5ps_GAZZ-2VBlz8dyMFX4MeALxUTLVYgH6F4Xe03OdRNasFgd73EWF194AZIEJbsKBA7lk7F7NIt1Mmav7E73piZdWI0ns8EOU4mPzddfXM5o8YtoVYhcS2pVOZzQmYInpLFumPSLEVcMn__ampvcWDReYZgGU5CNOpyaxmIrnZZg6Uyo8uAH8LFT9xpL-sFtcdd8VAYDBCVsHkxt_LhkMfxe3tDBWMUxpLUSzvpFbZCpMAziNWkFPv9luin8LCLSOCPKvRtncSWUbCT7BmLuVMwCpg12M34vUjDuc2wqCT8rfjG8rSfFLeUEng18JGPQjsPhgmdb0Ot6nffKignySBy8-uGoYTaWWOADc3SCrVWfUThexo57_Hk0oHm4IABnkjIOIIWqUdMELrblmvKRQ2xzZ0_G3Sb3ojuiP0hWx05V-EHobZtCBBfqZpigO3s1OxpWQfAjHIyCZW0pDMRqzpEMiIBMAwLV9DaerihzkDdHiIYaI_mFdHfniSntPkuVgfACvgnCPbJX8p8LvU5u64vRZK2nTEuGb8UewRMWPmCAqrLaVGw5iK0NjhJ7ITCinUwwzOx3C3feeGoali02ye1hyokZ-IaOhoACHrIHLCqY0RzwoiAri04t11g29xDquJ2dASPfDOQUZp5KEee1h2RDIrknfzSUdiDCviHp2kxTAVmPVUKzRnvU90Ta55C14RkkNlQS9CuqdXprmOxGFfpn_w0cMx4x1GOCJuB7kIGQ0AYPsFc0DjMTzyE-pqapsalSUL1PnFCQyq78T_B8W7B-gZjhCAcb7mmc86LH7B2gEG7n6f51VnLdyBBTG8AVQqN-0XgSt1waJsxvZke2i65y7NUdR3U4ZJxX5M3Oex8421HnJ2R64Zwphc7K0_sje8VgGc_irxqAiZB9yfG_7zxltBjrRs359Y04g6vcit1McA5svnscg7aZdeMDIn-Ez9ES46hpToFgDRhl5HF3bp6p_RaaEzadpkuGutWXD7EdpkWoEjrxEEm38XFw1iv3KoA7iSA7dDaqQOlJA580KZMYfqQb5qJGvkzPw7Pi6TFJDYqylH3fBWykCGwkOpSlTvd6FLNJ3V-xYJZ8EJwj_Ty-3lc-eiPzVNGK_8h0cgPYkvMk2CDIFk6ruUlQ6zbqNYNf6cWQm_kXsq3Nvjn7wtDJwUhXAVSYS-HZv30nBC9usJ-LrbmCjobdncpK2wnsUCUGkPQhkb2VuP15BlNDRk0wJcWgZv-TAFHlr_Py4-B2TLegWvIBf8OO5X-toyJPBHnV3hA5QQXTOEc5s-NiPnXc0b8MZA5B7i9hy9-BUZJPzaCIKW-iuy2H5Hd1bWKumVXsudcJae4VgEfJWrrY9BWHkB3r12-9gSw0pNA6QO1jEIvU60VJFj8V0ni0Hq_3Ahj22mYtcnPjroHtDU-J6AtACsLBAuLBMgNDrQKnDHOzejcRnQRr3v-n8EHrzelG24SJu4nGNj4012-ILweN8SF1WfdzB1vYBiFumH4xAN0Sn_Q2mvV35A3qGRDnajo8aWBiBie_lV-f74BfvcWrqMDWtSLSGo68EjM8-Z6LfMlJ0lkWrnoKrAbV7Qy5fStzW2RLmKiu3_QF6x9HgniJBFvmY7KKTzXszdxiDRf-_GRX_FA226QySWeTYtCwpteoUtpCVVR2WnnUekhzuJSdigymT9nONzZmCtgmY2yaqhsFUzKkLIlPY99r-X1MExPUvGcCIMWMpKU1Hep5JwzohhiQBTD05yeHIPkrqAAjBuFTxeD2-IPtmEkIQB_FDXziix9IsG5Zvlt2tOlHSStQvU4BVGJKdIwaNgB2K8ug-HQdzMkGFlrf1IT65UmUdePX7HrCLO7vO5ANqhYo5v7DW2mWQuUx9Ala35CimghIVtKNkjyKwoQZ9H694PXrFGf-rrEpPI5EctotY0_UQoWEn7ZZyh4Rjg1tlrUsGbgAHdQgGNIuWWT3-WuOGPtTTAa1TqiLPQEgadiDH1HC18yZwrXUw4I31cbErhcVS1hQgmDumcuoLlGQRVJkPthlBTylkJjjVzKUlBEkl57DL8abyQflSiRe_INPz_S7yXDmPOIsjJVuUh-0bHC-T6CuhCuZU-TmfUqXpXbxZ201wTDuCbOs5OHPc1GvwClz4FDqo2Q\",\n    \"tracking\": {\n        \"fingerprint\": \"45d12416701bfe9a38a14f429905ba02\",\n        \"utm_campaign\": \"_____\",\n        \"utm_source\": \"_____\",\n        \"utm_medium\": \"_____\",\n        \"utm_content\": \"_____\",\n        \"utm_term\": \"_____\",\n        \"salesforce_uuid\": \"VIBEMedia\"\n    },\n    \"scheduling_link_uuid\": \"yq9-9gm-2wf\",\n    \"locale\": \"de\"\n}"))
                    .build();
                try {
                    response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(response.body());

            }).start();
        }

    }
}