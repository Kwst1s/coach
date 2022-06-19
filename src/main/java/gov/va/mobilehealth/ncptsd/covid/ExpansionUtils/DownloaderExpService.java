package gov.va.mobilehealth.ncptsd.covid.ExpansionUtils;

import com.google.android.vending.expansion.downloader.impl.DownloaderService;

public class DownloaderExpService extends DownloaderService {
    public static final byte[] D = {8, -42, -2, 46, 3, 18, -106, -87, 24, 112, -73, -55, 9, 40, -6, -87, -32, 42, -11, 81};

    @Override // com.google.android.vending.expansion.downloader.impl.DownloaderService
    public String r() {
        return ExpAlarmReceiver.class.getName();
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloaderService
    public String u() {
        return "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw9T50dnS8ULv2zb/nwk56sXuelFlyR3jA8Bv4VLdUshST+GNMlSPNLh5tMNxourJYjV8NOMnljxsLMXSRkMQ/45cv+hAoZhXcZMk/v8YhS/E8wNS5BK1Z/Ggn9agi5hZX73ktvVAvi4qR2H9LDqGJtj2N/VAEpecfhqTonqRbrNbaLY6BtF0aR/+vVrf/dMTOptfRtcep0wKvvW3ct2viTDeZbJcHYDnsux7MH96SKVg3dPAGQmi7LCztjCJm0k68cjmVGrFNXQHzFjzX0htZFtvUpZlaN56+OfoN304r+adperyEADmUGLijJ5OhfyLGkMV8A3hQcDKlaUT3vaJBwIDAQAB";
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloaderService
    public byte[] v() {
        return D;
    }
}
