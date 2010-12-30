package pl.touk.mproch

class SampleService {

    static transactional = false
	
	//a po co komu baza danych :D
	def counter = 2;
	def set = [[id:"1",Title:'Title1',Summary:"summary1"],[id:"2",Title:'Title2',Summary:'summary33']]
	

	def fetch = { params ->
		def ret = set.findAll{w -> w.Summary.startsWith(params.Summary == null ? '' : "${params.Summary}") }
		println "fetching ${params} found: ${ret} in ${set}"
		ret
	}
	def add = { params ->
		def nId = "${++counter}";		
		set.add([id: nId, Title : params['Title'], Summary : params['Summary']])
		println "after add: ${set} used params: ${params} returning ${findById(nId)}"
		findById(nId)
	}
	def findById = { id ->
		set.find{ w -> w.id == id}
	}
	def update = { params ->
		def act = findById(params.id)
		act.Title = params.Title
		act.Summary = params.Summary	
		println "after update: ${set} used params: ${params} returning: ${act}"
		act
		
	}
}
