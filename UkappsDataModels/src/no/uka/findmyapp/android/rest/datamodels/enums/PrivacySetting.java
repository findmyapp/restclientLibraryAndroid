package no.uka.findmyapp.android.rest.datamodels.enums;

public enum PrivacySetting {
//	With which group I will share my information:
	ANYONE,
	FRIENDS,
	ONLY_ME;

	public static PrivacySetting getSetting(int a){
		switch(a){
			case 1:
				return ANYONE;
			case 2:
				return FRIENDS;
			default:
				return ONLY_ME;
				// If you input a bad integer then you will get the strongest privacy back
				// Should we cast exception or null instead?
		}
	}
	
	public static int toInt( PrivacySetting p){
		switch(p){
		case ANYONE:
			return 1;
		case FRIENDS:
			return 2;
		default:
			return 3; 
			
		}
	}
}