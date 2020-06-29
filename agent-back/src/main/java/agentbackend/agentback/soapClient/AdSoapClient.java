package agentbackend.agentback.soapClient;

import agentbackend.agentback.config.SoapProperties;
import agentbackend.agentback.controller.dto.AdDTO;
import com.car_rent.agent_api.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class AdSoapClient extends WebServiceGatewaySupport {

    public CreateAdResponse createAd(AdDTO adDTO, String email) {
        CreateAdRequest request = new CreateAdRequest();

        AdFormDetails adDetails = new AdFormDetails();
        adDetails.setCarId(adDTO.getCarId());
        adDetails.setPlace(adDTO.getPlace());
        adDetails.setStartDate(adDTO.getStartDate());
        adDetails.setEndDate(adDTO.getEndDate());

        request.setEmail(email);
        request.setAdDetails(adDetails);

        return (CreateAdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(SoapProperties.ADS_WSDL, request,
                        new SoapActionCallback(SoapProperties.NAMESPACE_URI + "/createAdRequest"));
    }

    public ActivateAdResponse activateAd(Long id, String email) {
        ActivateAdRequest request = new ActivateAdRequest();

        request.setEmail(email);
        request.setId(id);

        return (ActivateAdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(SoapProperties.ADS_WSDL, request,
                        new SoapActionCallback(SoapProperties.NAMESPACE_URI + "/activateAdRequest"));
    }

    public DeactivateAdResponse deactivateAd(Long id, String email) {
        DeactivateAdRequest request = new DeactivateAdRequest();

        request.setEmail(email);
        request.setId(id);

        return (DeactivateAdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(SoapProperties.ADS_WSDL, request,
                        new SoapActionCallback(SoapProperties.NAMESPACE_URI + "/deactivateAdRequest"));
    }

    public EditAdResponse editAd(Long id, AdDTO adDTO, String email) {
        EditAdRequest request = new EditAdRequest();
        AdFormDetails adDetails = new AdFormDetails();
        adDetails.setCarId(adDTO.getCarId());
        adDetails.setPlace(adDTO.getPlace());
        adDetails.setStartDate(adDTO.getStartDate());
        adDetails.setEndDate(adDTO.getEndDate());

        request.setEmail(email);
        request.setId(id);
        request.setAdDetails(adDetails);

        return (EditAdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(SoapProperties.ADS_WSDL, request,
                        new SoapActionCallback(SoapProperties.NAMESPACE_URI + "/editAdRequest"));
    }

    public GetAdsResponse getAds(String email) {
        GetAdsRequest request = new GetAdsRequest();
        request.setEmail(email);

        return (GetAdsResponse) getWebServiceTemplate()
                .marshalSendAndReceive(SoapProperties.ADS_WSDL, request,
                        new SoapActionCallback(SoapProperties.NAMESPACE_URI + "/getAdsRequest"));
    }


}