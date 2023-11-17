export class Advertisement {
    advertisementId:string;
    advertisementPricePerQuintal:string;
    advertisementCropId:string;
    quantityInQuintals:string;
    purpose:string;
    targetedAudience:string;
    advertisementOwnerId:string;
    cropImage:string;
    description:string;
    cropName: string;

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
   
    getCropName(advertisementCropId)
    {
        if(advertisementCropId=="C10001")
        {
            return("Wheat");
        }
        else if(advertisementCropId=="C10002")
        {
            return("Rice");
        }
    }

}