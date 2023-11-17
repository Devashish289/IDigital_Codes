export class AdvertisementEntity {
    advertisementId:string;
    advertisementPricePerQuintal:string;
    advertisementCropId:string;
    quantityInQuintals:string;
    purpose:string;
    targetedAudience:string;
    advertisementOwnerId:string;
    
    constructor(advertisementId,advertisementPricePerQuintal,advertisementCropId,quantityInQuintals,purpose,targetedAudience,advertisementOwnerId)
    {
        this.advertisementId=advertisementId;
        this.advertisementPricePerQuintal=advertisementPricePerQuintal;
        this.advertisementCropId=advertisementCropId;
        this.quantityInQuintals=quantityInQuintals;
        this.purpose=purpose;
        this.targetedAudience=targetedAudience;
        this.advertisementOwnerId=advertisementOwnerId;
    }
}