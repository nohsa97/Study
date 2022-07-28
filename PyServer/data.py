class User :
    def __init__(self,serverId,charId,charName,jobGrowName) -> None:
        self.serverId = serverId
        self.charId = charId
        self.charName = charName
        self.jobGrowName = jobGrowName

    def __str__(self) -> str:
        return " 캐릭터 : '{self.charName}' "


