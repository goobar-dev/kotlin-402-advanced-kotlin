package variance

interface ValueStore

abstract class FIAT : ValueStore
abstract class STOCK : ValueStore

class USD : FIAT()
class CAN : FIAT()

class APPL : STOCK()
class MSFT : STOCK()